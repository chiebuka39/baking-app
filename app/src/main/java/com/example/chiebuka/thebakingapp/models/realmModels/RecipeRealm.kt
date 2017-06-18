package com.example.chiebuka.thebakingapp.models.realmModels


import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class RecipeRealm(

		var image: String? = null,

		var servings: Int? = null,

		@PrimaryKey
		var name: String? = null,

		var ingredients: RealmList<IngredientsItemRealm?>? = null,

		var id: Int? = null,

		var steps: RealmList<StepsItemRealm?>? = null
): RealmObject()