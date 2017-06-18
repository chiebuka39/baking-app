package com.example.chiebuka.thebakingapp.data

import com.example.chiebuka.thebakingapp.models.Recipe
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by chiebuka on 6/16/17.
 */
interface RecipeApiService {
    @GET("baking.json")
    fun recipes() : Observable<ArrayList<Recipe>>

    /**
     * Companion object to create the RecipeApiService
     */

    companion object Factory {
        fun create(): RecipeApiService{
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_" +
                            "baking/")
                    .build()

            return retrofit.create(RecipeApiService::class.java)
        }
    }
}
