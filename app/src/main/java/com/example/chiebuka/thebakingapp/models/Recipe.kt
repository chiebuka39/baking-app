package com.example.chiebuka.thebakingapp.models

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@javax.annotation.Generated("com.robohorse.robopojogenerator")
data class Recipe(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("servings")
	val servings: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("ingredients")
	val ingredients: List<IngredientsItem?>? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("steps")
	val steps: List<StepsItem?>? = null
)