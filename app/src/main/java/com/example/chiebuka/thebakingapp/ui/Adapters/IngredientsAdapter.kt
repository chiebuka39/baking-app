package com.example.chiebuka.thebakingapp.ui.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.chiebuka.thebakingapp.R
import com.example.chiebuka.thebakingapp.models.IngredientsItem
import io.realm.RealmList

/**
 * Created by chiebuka on 6/21/17.
 */
class IngredientsAdapter(val mContext: Context, val ingredients: RealmList<IngredientsItem?>?)
    : RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder>() {


    override fun getItemCount(): Int = ingredients?.size as Int

    override fun onBindViewHolder(viewHolder: IngredientsViewHolder?, p1: Int) {
        val ingredient = ingredients?.get(p1)
        ingredient?.let { viewHolder?.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, p1: Int): IngredientsViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent?.context)
        val view : View = inflater.inflate(R.layout.ingredients_item_layout,parent,false)

        return IngredientsViewHolder(view)
    }


    class IngredientsViewHolder(val itemVIew : View) : RecyclerView.ViewHolder(itemVIew) {

        val ingredients_name = itemVIew.findViewById(R.id.ingredient_name) as TextView
        val ingredients_quantity = itemVIew.findViewById(R.id.ingredient_quantity) as TextView
        val ingredients_measure = itemVIew.findViewById(R.id.ingredient_measure) as TextView

        fun bind(ingredient: IngredientsItem){
            ingredients_name.text = ingredient.ingredient
            ingredients_quantity.text = "${ingredient.quantity}"
            ingredients_measure.text = ingredient.measure
        }
    }
}