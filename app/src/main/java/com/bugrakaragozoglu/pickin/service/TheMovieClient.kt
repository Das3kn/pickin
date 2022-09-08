package com.bugrakaragozoglu.pickin.service

import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

object TheMovieClient {
    val baseURL: String = "https://api.themoviedb.org/3/"
    const val apiKey = "808f9e99f5c44c0619283e52ca6b455"
    private var retrofit: Retrofit? = null

    fun getInstance() : TheMovieAPI{

        val client: OkHttpClient = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .protocols(Collections.singletonList(Protocol.HTTP_1_1))
                .build()

        retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(baseURL)
            .build()
        return retrofit!!.create(TheMovieAPI::class.java)
    }
}