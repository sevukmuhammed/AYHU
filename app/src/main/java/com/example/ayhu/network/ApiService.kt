package com.example.movieclone.network

import com.example.ayhu.model.FuelInformation
import com.example.ayhu.model.VehicleInformation
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


/*
Created by Muhammed Yusuf ÇİL 
Date : 2/18/2020
*/
interface ApiService{
    @POST("AjaxProcess/GetFuelPricesList")
    fun getFuelInfo(@Body Cityname:String?): Call<FuelInformation>

    @POST("markalar/")
    fun getVehicleInfo():Call<VehicleInformation>
}
