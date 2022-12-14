package com.bugrakaragozoglu.pickin.model

import androidx.appcompat.widget.DialogTitle
import com.google.gson.annotations.SerializedName
import kotlin.random.Random

var modelList = mutableListOf<ResponseModel>()
class ResponseModel (
       /* @SerializedName("backdrop_path")
        val backdrop_path: Any,
        @SerializedName("title")
        val title: String,
        @SerializedName("overview")
        val overview: String,
        @SerializedName("poster_path")
        val poster_path : String
        )*/
        val movieTitle: String ,
        val movieOverview : String,
        val moviePosterPath : Int,
        val movieBackdroppath : Int,
        val id: Int = Random.nextInt())