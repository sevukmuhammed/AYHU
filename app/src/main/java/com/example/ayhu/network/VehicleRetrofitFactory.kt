package com.example.ayhu.network

import com.example.movieclone.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
  Created by Muhammed Yusuf ÇİL
  25.04.2020 - 15:43    
  myusufcl7@gmail.com
*/
//https://www.carqueryapi.com/api/0.3/?callback=?&cmd=getMakes&year=2000&sold_in_us=1

class VehicleRetrofitFactory {
    companion object {

        var BASE_URL =
            "https://www.carqueryapi.com/api/0.3/"

        fun getFuelInformation(): VehicleApiService {
            val logInterceptor = HttpLoggingInterceptor()
            logInterceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(logInterceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(client)
                .build()
            return retrofit.create(VehicleApiService::class.java)
        }
    }
}