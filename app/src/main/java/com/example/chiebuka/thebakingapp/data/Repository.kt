package com.example.chiebuka.thebakingapp.data

import com.example.chiebuka.thebakingapp.models.Recipe
import io.reactivex.Observable

/**
 * Created by chiebuka on 6/16/17.
 */
class Repository(val apiService: RecipeApiService) {
    fun getRepipes() : Observable<ArrayList<Recipe>>{
        return apiService.recipes()
    }

}