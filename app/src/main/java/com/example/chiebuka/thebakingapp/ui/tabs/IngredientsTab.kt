package com.example.chiebuka.thebakingapp.ui.tabs


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.chiebuka.thebakingapp.R
import com.example.chiebuka.thebakingapp.models.Recipe
import com.example.chiebuka.thebakingapp.ui.Adapters.IngredientsAdapter


/**
 * A simple [Fragment] subclass.
 */
class IngredientsTab : Fragment() {

    companion object{
        fun newInstance(recipe: Recipe): IngredientsTab{
            val ingredients  = IngredientsTab()
            val args = Bundle()
            args.putSerializable("RECIPES", recipe)

            ingredients.arguments = args

            return ingredients
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_recipe_tabs, container, false)
        val recipe = arguments.getSerializable("RECIPES") as Recipe
        Log.v("Ingredients", "${recipe.ingredients?.size}")

        val recyclerIngredients = view.findViewById(R.id.recycler_ingredients) as RecyclerView
        val ingredientsAdapter = IngredientsAdapter(activity,recipe.ingredients)
        recyclerIngredients.adapter = ingredientsAdapter
        recyclerIngredients.layoutManager = LinearLayoutManager(activity)


        return view
    }

}// Required empty public constructor
