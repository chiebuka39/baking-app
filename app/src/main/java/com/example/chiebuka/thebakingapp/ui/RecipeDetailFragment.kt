package com.example.chiebuka.thebakingapp.ui


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.chiebuka.thebakingapp.R
import com.example.chiebuka.thebakingapp.models.Recipe
import com.example.chiebuka.thebakingapp.ui.Adapters.RecipePagerAdapter
import com.vicpin.krealmextensions.query
import org.greenrobot.eventbus.EventBus


/**
 * A simple [Fragment] subclass.
 */
class RecipeDetailFragment : Fragment() {

    val ARG_RECIPENAME = "recipe_name"

    companion object{
        val ARG_RECIPENAME = "recipe_name"
        fun newInstance(name: String): RecipeDetailFragment {
            val recipe = RecipeDetailFragment()

            val args = Bundle()
            args.putString(ARG_RECIPENAME,name)
            recipe.arguments = args
            return recipe
        }
    }



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater!!.inflate(R.layout.fragment_recipe_detail, container, false)

        val tabLayout = view.findViewById(R.id.tab_layout) as TabLayout
        tabLayout.addTab(tabLayout.newTab().setText("Ingredients"))
        tabLayout.addTab(tabLayout.newTab().setText("Steps"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL



        val pager = view.findViewById(R.id.pager) as ViewPager

        val recipe_name = arguments.getString(ARG_RECIPENAME)
        val recipes = Recipe().query { it.equalTo("name", recipe_name) }

        val recipePagerAdapter = RecipePagerAdapter(activity.supportFragmentManager,
                tabLayout.tabCount, recipes.get(0))
        pager.adapter = recipePagerAdapter

        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(MySelectedListener(pager,
                arguments.getString(ARG_RECIPENAME)))

        return view;
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recipe_name = arguments.getString(ARG_RECIPENAME)

        //val recipes = Recipe().query { it.equalTo("name", recipe_name) }

        Log.v("RECIPE", recipe_name)


    }



    class MySelectedListener(val pager: ViewPager, val name: String) : TabLayout.OnTabSelectedListener {
        override fun onTabReselected(tab: TabLayout.Tab?) {

        }

        override fun onTabUnselected(p0: TabLayout.Tab?) {

        }

        override fun onTabSelected(tab: TabLayout.Tab?) {
            if (tab != null) {
                pager.currentItem = tab.position
                //EventBus.getDefault().post()
            }
        }
    }



}
