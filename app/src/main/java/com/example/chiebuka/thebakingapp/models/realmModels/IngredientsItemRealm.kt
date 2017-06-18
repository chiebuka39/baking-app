package com.example.chiebuka.thebakingapp.models.realmModels


import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class IngredientsItemRealm(
		var quantity: Double? = null,
		var measure: String? = null,
		@PrimaryKey
		var ingredient: String? = null) : RealmObject(){

}