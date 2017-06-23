package com.example.chiebuka.thebakingapp.ui.Adapters


import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.util.Log
import com.example.chiebuka.thebakingapp.models.StepsItem
import com.example.chiebuka.thebakingapp.ui.tabs.stepsTab.Steps_Fragment
import io.realm.RealmList

/**
 * Created by chiebuka on 6/22/17.
 */
class StepsPagerAdapter(val fm: FragmentManager, val steps: RealmList<StepsItem?>?)
    : FragmentStatePagerAdapter(fm) {

    var list: MutableList<Steps_Fragment>? = null;

    init {
        Log.v("Success", "yes")
    }

    override fun getItem(p0: Int): Steps_Fragment? {
        return Steps_Fragment.newInstance(steps?.get(p0) as StepsItem)
    }

    override fun getCount(): Int = steps?.size as Int

}