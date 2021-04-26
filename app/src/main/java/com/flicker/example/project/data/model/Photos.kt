package com.flicker.example.project.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Photos (

	@Expose
	@SerializedName("page") val page : Int,
	@Expose
	@SerializedName("pages") val pages : Int,
	@Expose
	@SerializedName("perpage") val perpage : Int,
	@Expose
	@SerializedName("total") val total : Int,
	@Expose
	@SerializedName("photo") val photo : List<Post>
)