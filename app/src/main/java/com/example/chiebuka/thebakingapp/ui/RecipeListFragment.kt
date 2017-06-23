package com.example.chiebuka.thebakingapp.ui


import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar

import com.example.chiebuka.thebakingapp.R
import com.example.chiebuka.thebakingapp.data.RepositoryProvider
import com.example.chiebuka.thebakingapp.models.Recipe
import com.example.chiebuka.thebakingapp.models.realmModels.IngredientsItemRealm
import com.example.chiebuka.thebakingapp.models.realmModels.RecipeRealm
import com.example.chiebuka.thebakingapp.models.realmModels.StepsItemRealm
import com.example.chiebuka.thebakingapp.ui.Adapters.RecipeAdapter
import com.vicpin.krealmextensions.queryAll
import com.vicpin.krealmextensions.saveAll
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.realm.RealmList
import org.greenrobot.eventbus.EventBus


/**
 * A simple [Fragment] subclass.
 */
class RecipeListFragment : Fragment() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    val PREFS_FILENAME = "com.example.chiebuka.thebakingapp"
    val FIRST_LOAD = "first_load"
    var prefs :SharedPreferences? = null




    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_recipe_list, container, false)

        val recycler = view.findViewById(R.id.recipe_recycler) as RecyclerView;
        val progress = view.findViewById(R.id.progress) as ProgressBar

        val repository = RepositoryProvider.provideReposotory()

        val recipes : List<Recipe>

        prefs = activity.getSharedPreferences(PREFS_FILENAME, 0)
        val firstLoad = prefs!!.getBoolean(FIRST_LOAD, true)

        when(firstLoad){
            false ->{
                recipes = Recipe().queryAll()
                val adapter = RecipeAdapter(recipes as ArrayList<Recipe>,activity)
                recycler.adapter = adapter
                recycler.layoutManager = LinearLayoutManager(activity)
                recycler.setHasFixedSize(true)
                Log.v("RESULT2", recipes.get(0).name)


            }
            true ->
                compositeDisposable.add(
                        repository.getRepipes()
                                .observeOn(AndroidSchedulers.mainThread())
                                .doOnNext({recipe ->
                                    displayProgress(true, recycler,progress)
                                    Log.v("RESULT", "show")
                                })
                                .subscribeOn(Schedulers.io())
                                .subscribe({
                                    result ->
                                    displayProgress(false, recycler,progress)
                                    result.saveAll()
                                    val adapter = RecipeAdapter(result, activity)
                                    recycler.adapter = adapter
                                    recycler.layoutManager = LinearLayoutManager(activity)
                                    val editor = prefs!!.edit()
                                    editor.putBoolean(FIRST_LOAD, false)
                                    editor.apply()

                                },{
                                    error -> error.printStackTrace()
                                })
                )
        }



        return view;
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onStop() {
        super.onStop()

    }

    // TODO: do this on a background thread
    /*fun saveRecipes(recipes: ArrayList<Recipe>):ArrayList<RecipeRealm>{
        val recipe: ArrayList<RecipeRealm> = arrayListOf()

        recipes.forEach({r ->
                val ingredients_ : RealmList<IngredientsItemRealm?>? = RealmList()
                val steps_ : RealmList<StepsItemRealm?>? = RealmList()
                r.ingredients?.forEach { i ->
                    ingredients_!!.add(IngredientsItemRealm(i!!.quantity, i.measure, i.ingredient))
                }
                r.steps?.forEach { s ->
                    steps_!!.add(StepsItemRealm(s!!.videoURL,s.description,s.id,
                            s.shortDescription, s.thumbnailURL))
                }

                recipe.add(RecipeRealm(r.image, r.servings, r.name,ingredients_,r.id, steps_))
        })

        recipe.saveAll()
        return recipe
    }*/

    fun displayProgress(display: Boolean, recycler: RecyclerView, progress : ProgressBar){
        when(display){
            true -> {
                recycler.visibility = View.INVISIBLE
                progress.visibility = View.VISIBLE
            }
            false -> {
                recycler.visibility = View.VISIBLE
                progress.visibility = View.INVISIBLE
            }
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

}// Required empty public constructor
