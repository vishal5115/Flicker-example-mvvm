package com.flicker.example.project.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.flicker.example.project.data.model.Photos


data class PostListResponse(

    @Expose
    @SerializedName("photos") val photos : Photos,

    @Expose
    @SerializedName("stat") val stat : String
)