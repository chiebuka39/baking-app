package com.example.chiebuka.thebakingapp.ui.Adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.util.Log
import com.example.chiebuka.thebakingapp.models.Recipe
import com.example.chiebuka.thebakingapp.ui.tabs.IngredientsTab
import com.example.chiebuka.thebakingapp.ui.tabs.StepTab

/**
 * Created by chiebuka on 6/21/17.
 */
class RecipePagerAdapter(val fm: FragmentManager, val tabNum: Int, val recipe:Recipe
): FragmentStatePagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> {
                Log.v("RECIPE", recipe.name)
                val tab1 = IngredientsTab.newInstance(recipe)
                return tab1
            }
            else -> {
                val tab2 = StepTab.newInstance(recipe)
                return tab2
            }
        }
    }

    override fun getCount() = tabNum

}