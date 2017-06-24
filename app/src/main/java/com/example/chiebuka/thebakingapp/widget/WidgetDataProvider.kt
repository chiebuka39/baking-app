package com.example.chiebuka.thebakingapp.widget

import android.content.Context
import android.content.Intent
import android.os.Parcel
import android.util.Log
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.example.chiebuka.thebakingapp.R
import com.example.chiebuka.thebakingapp.models.Recipe
import com.vicpin.krealmextensions.queryAll
import com.vicpin.krealmextensions.queryFirst
import io.realm.RealmList


/**
 * Created by chiebuka on 6/23/17.
 */
class WidgetDataProvider(val context: Context, val intent: Intent):
        RemoteViewsService.RemoteViewsFactory {

     var recipe : Recipe? = null
     var r : List<Recipe>? = null
     var position = -1
     var limit = 3

    override fun getLoadingView(): RemoteViews {
         return RemoteViews(Parcel.obtain())
    }

    override fun onDataSetChanged() {
        Log.v("Harry", "dataset changed")
        position++
        Log.v("Harry", "$position")
        recipe = r?.get(position)

        if(position == limit) {
            position = -1
        }
    }

    override fun hasStableIds(): Boolean {
       return true
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun onDestroy() {
    }

    override fun onCreate() {
        Log.v("Harry", "dataset changed2")
        r = Recipe().queryAll()
        //recipe = Recipe().queryFirst()
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getViewAt(position: Int): RemoteViews {
       val remoteViews = RemoteViews(context.packageName,
               R.layout.list_view_item )
        if(position == 0){
            remoteViews.setTextViewText(R.id.list_title,
                    "Recipe name:  ");
            remoteViews.setTextViewText(R.id.list_measure,
                    recipe?.name);
        }else{
            remoteViews.setTextViewText(R.id.list_title,
                    recipe?.ingredients?.get(position)?.ingredient);
            remoteViews.setTextViewText(R.id.list_measure,
                    recipe?.ingredients?.get(position)?.measure);
            remoteViews.setTextViewText(R.id.list_weight,
                    recipe?.ingredients?.get(position)?.quantity.toString());
        }


        return remoteViews
    }

    override fun getCount(): Int {
         return recipe?.ingredients?.size as Int//Recipe().queryFirst()?.ingredients?.size as Int
    }


}