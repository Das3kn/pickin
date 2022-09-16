package com.bugrakaragozoglu.pickin.service

import com.bugrakaragozoglu.pickin.model.CommonResponse
import com.bugrakaragozoglu.pickin.model.Movie
import io.reactivex.Observable
import retrofit2.http.GET

interface TheMovieAPI {
        @GET("movie/now_playing?api_key=${TheMovieClient.apiKey}")
        fun getNowPlaying(): Observable<CommonResponse>
        @GET("movie/upcoming?api_key=${TheMovieClient.apiKey}")
        fun getUpComing(): Observable<CommonResponse>

}
