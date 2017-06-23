package com.example.chiebuka.thebakingapp.models

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.RealmClass
import java.io.Serializable

@javax.annotation.Generated("com.robohorse.robopojogenerator")
@RealmClass
open class Recipe() :Serializable, RealmObject(){
	@field:SerializedName("image")
	var image: String? = null

	@field:SerializedName("servings")
	var servings: Int? = null

	@field:SerializedName("name")
	var name: String? = null

	@field:SerializedName("ingredients")
	var ingredients: RealmList<IngredientsItem?>? = null

	@field:SerializedName("id")
	var id: Int? = null

	@field:SerializedName("steps")
	var steps: RealmList<StepsItem?>? = null
}