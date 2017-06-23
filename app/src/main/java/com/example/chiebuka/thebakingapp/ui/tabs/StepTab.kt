package com.example.chiebuka.thebakingapp.ui.tabs


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast

import com.example.chiebuka.thebakingapp.R
import com.example.chiebuka.thebakingapp.models.Recipe
import com.example.chiebuka.thebakingapp.ui.Adapters.StepsPagerAdapter


/**
 * A simple [Fragment] subclass.
 */
class StepTab : Fragment() {

    companion object{
        fun newInstance(recipe: Recipe): StepTab{
            val steps  = StepTab()
            val args = Bundle()
            args.putSerializable("RECIPES", recipe)

            steps.arguments = args

            return steps
        }
    }

    var position = -1


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_step_tabs, container, false)

        val view_pager = view.findViewById(R.id.steps_pager) as ViewPager
        val prev = view.findViewById(R.id.left) as ImageView
        val next = view.findViewById(R.id.right) as ImageView
        val recipe = arguments.getSerializable("RECIPES") as Recipe

        val stepsAdapter = StepsPagerAdapter(activity.supportFragmentManager,
                recipe.steps)
        view_pager.adapter = stepsAdapter


        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    prev.setEnabled(false)
                    next.setEnabled(true)
                } else {
                    prev.setEnabled(true)
                    //TODO: remove !!
                    if (position == recipe.steps?.size!! - 1) {
                        next.setEnabled(false)
                    } else {
                        next.setEnabled(true)
                    }
                }
            }

        })

        prev.setOnClickListener { v: View? ->
            Toast.makeText(activity,"Prev",Toast.LENGTH_SHORT).show()
            position--
            view_pager.setCurrentItem(position)
        }

        next.setOnClickListener{ v ->
            Toast.makeText(activity,"Next",Toast.LENGTH_SHORT).show()
            ++position
            view_pager.setCurrentItem(position)
        }
        if (position != -1) view_pager.setCurrentItem(position)

        return view;
    }


}// Required empty public constructor
