package com.bugrakaragozoglu.pickin.model

import com.google.gson.annotations.SerializedName

data class CommonResponse(
    val dates: Dates,
    val page: Int,
    @SerializedName("results")
    val movies: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)