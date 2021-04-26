package com.flicker.example.project.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Post(

    @Expose
    @SerializedName("id") val id : String,
    @Expose
    @SerializedName("owner") val owner : String,
    @Expose
    @SerializedName("secret") val secret : String,
    @Expose
    @SerializedName("server") val server : Int,
    @Expose
    @SerializedName("farm") val farm : Int,
    @Expose
    @SerializedName("title") val title : String,
    @Expose
    @SerializedName("ispublic") val ispublic : Int,
    @Expose
    @SerializedName("isfriend") val isfriend : Int,
    @Expose
    @SerializedName("isfamily") val isfamily : Int,
    @Expose
    @SerializedName("url_s") val url_s : String,
    @Expose
    @SerializedName("height_s") val height_s : Int,
    @Expose
    @SerializedName("width_s") val width_s : Int
)