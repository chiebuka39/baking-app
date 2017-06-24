package com.example.chiebuka.thebakingapp.ui.activities


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.chiebuka.thebakingapp.Events.SelectedRecipeEvent
import com.example.chiebuka.thebakingapp.R
import com.example.chiebuka.thebakingapp.ui.RecipeDetailFragment
import com.example.chiebuka.thebakingapp.ui.RecipeListFragment
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        if(findViewById(R.id.container) != null){
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, RecipeListFragment())
                    .commit()
        }else if(findViewById(R.id.multipane_container) != null){
            Log.v("MULTIPANE", "multipane")
            supportFragmentManager.beginTransaction()
                    .replace(R.id.recipe_list_container, RecipeListFragment())
                    .commit()
        }

    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe
    fun onSelectedRecipeEvent(e : SelectedRecipeEvent){
        val re = e.recipe.name?.let { RecipeDetailFragment.newInstance(it) }

        if(findViewById(R.id.container) != null){
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, re)
                    .commit()
        }else if(findViewById(R.id.multipane_container) != null){
            Log.v("MULTIPANE", "multipane2")
            supportFragmentManager.beginTransaction()
                    .replace(R.id.recipe_detail_container, re)
                    .commit()
        }
    }





    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


}
