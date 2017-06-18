package com.example.chiebuka.thebakingapp.models

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import io.realm.annotations.RealmClass

@Generated("com.robohorse.robopojogenerator")
@RealmClass
data class IngredientsItem(

	@field:SerializedName("quantity")
	val quantity: Double? = null,

	@field:SerializedName("measure")
	val measure: String? = null,

	@field:SerializedName("ingredient")
	val ingredient: String? = null
)