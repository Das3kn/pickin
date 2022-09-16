package com.bugrakaragozoglu.pickin.model

data class Movie(
    val adult: Boolean,
    val genre_ids: List<Int>,
    val title: String,
    val overview: String,
    val poster_path: String,
    val backdrop_path: String,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val popularity: Double,
    val release_date: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

