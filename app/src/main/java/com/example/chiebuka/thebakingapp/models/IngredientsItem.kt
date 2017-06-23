package com.example.chiebuka.thebakingapp.models

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.RealmClass
import java.io.Serializable

@Generated("com.robohorse.robopojogenerator")
@RealmClass
open class IngredientsItem() : Serializable , RealmObject(){

	@field:SerializedName("quantity")
	var quantity: Double? = null

	@field:SerializedName("measure")
	var measure: String? = null

	@field:SerializedName("ingredient")
	var ingredient: String? = null
}