package com.example.movieclone.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Headers

/* 
Created by Muhammed Yusuf ÇİL 
Date : 2/18/2020
*/

class RetrofitFactory {
    companion object {
        var BASE_URL =
        "https://api.collectapi.com/"
        fun getFuelInformation(): ApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}