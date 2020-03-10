package com.example.movieclone.network

import com.example.ayhu.model.FuelInformation
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


/*
Created by Muhammed Yusuf ÇİL 
Date : 2/18/2020
*/
interface ApiService{
    @POST("AjaxProcess/GetFuelPricesList")
    fun getFuelInfo(@Body Cityname:String?): Call<FuelInformation>
}
