package com.example.chiebuka.thebakingapp.data

/**
 * Created by chiebuka on 6/16/17.
 */
object RepositoryProvider {
    fun provideReposotory(): Repository{
        return Repository(RecipeApiService.Factory.create());
    }
}