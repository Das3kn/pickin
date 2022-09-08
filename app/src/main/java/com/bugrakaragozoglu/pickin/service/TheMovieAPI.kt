package com.bugrakaragozoglu.pickin.service

import com.bugrakaragozoglu.pickin.model.NowPlayingResponse
import com.bugrakaragozoglu.pickin.model.ResponseModel
import io.reactivex.Observable
import retrofit2.http.GET

interface TheMovieAPI {
        @GET("movie/now_playing?api_key=${TheMovieClient.apiKey}")
        fun getNowPlaying(): Observable<NowPlayingResponse>
        @GET("movie/upcoming?api_key=${TheMovieClient.apiKey}")
        fun getUpComing(): Observable<List<ResponseModel>>
}
//https://api.themoviedb.org/3/movie/now_playing?api_key=808f9e99f5c44c0619283e52ca6b455c
//https://api.themoviedb.org/3/movie/upcoming?api_key=808f9e99f5c44c0619283e52ca6b455c