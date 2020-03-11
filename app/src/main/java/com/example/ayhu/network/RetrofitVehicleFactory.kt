package com.example.ayhu.network

import com.example.movieclone.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitVehicleFactory {
    companion object {
        var BASE_URL =
            "api.otoendeks.com/"
        fun getVehicleInformation(): ApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}