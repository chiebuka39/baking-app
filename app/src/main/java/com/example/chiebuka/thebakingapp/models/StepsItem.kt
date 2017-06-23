package com.example.chiebuka.thebakingapp.models

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.RealmClass
import java.io.Serializable

@Generated("com.robohorse.robopojogenerator")
@RealmClass
open class StepsItem() : Serializable, RealmObject(){

	@field:SerializedName("videoURL")
	var videoURL: String? = null

	@field:SerializedName("description")
	var description: String? = null

	@field:SerializedName("id")
	var id: Int? = null

	@field:SerializedName("shortDescription")
	var shortDescription: String? = null

	@field:SerializedName("thumbnailURL")
	var thumbnailURL: String? = null
}