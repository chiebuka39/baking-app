package com.example.chiebuka.thebakingapp.ui.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.chiebuka.thebakingapp.Events.SelectedRecipeEvent
import com.example.chiebuka.thebakingapp.R
import com.example.chiebuka.thebakingapp.models.Recipe
import org.greenrobot.eventbus.EventBus

/**
 * Created by chiebuka on 6/16/17.
 */
class RecipeAdapter(val recipeList: ArrayList<Recipe>, val mContext: Context) :
        RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    override fun onBindViewHolder(viewHolder: RecipeViewHolder?, p1: Int) {
        val recipe = recipeList.get(p1)
        viewHolder?.bind(recipe)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, p1: Int): RecipeViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent?.context)
        val view : View = inflater.inflate(R.layout.recipe_item,parent,false)

        return RecipeViewHolder(view)
    }

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val recipeName = itemView.findViewById(R.id.recipeName) as TextView


        fun bind(recipe: Recipe){
            recipeName.setText(recipe.name)
            itemView.setOnClickListener { v ->
                Toast.makeText(recipeName.context, "harry", Toast.LENGTH_SHORT).show()
                EventBus.getDefault().post(SelectedRecipeEvent(recipe))
            }
        }



    }
}