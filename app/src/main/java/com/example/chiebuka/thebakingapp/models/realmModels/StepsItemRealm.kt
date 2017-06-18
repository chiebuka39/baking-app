package com.example.chiebuka.thebakingapp.models.realmModels

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class StepsItemRealm(


	var videoURL: String? = null,

	var description: String? = null,

	@PrimaryKey
	var id: Int? = null,

	var shortDescription: String? = null,

	var thumbnailURL: String? = null
): RealmObject()