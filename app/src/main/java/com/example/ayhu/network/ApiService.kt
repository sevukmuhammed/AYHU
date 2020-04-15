package com.example.movieclone.network

import com.example.ayhu.data.model.FuelInformation
import com.example.ayhu.data.model.VehicleInformation
import retrofit2.Call
import retrofit2.http.*

/*
Created by Batuhan Uzunoğlu
Date : 2/18/2020
*/

interface ApiService {

//    @POST("AjaxProcess/GetFuelPricesList")
//    fun getFuelInfo(@Body Cityname: String?): Call<FuelInformation>

    @Headers(
        "authorization: apikey 0IZa4vCIVRfJrdMyICeofj:0CdCwHCfYoVthZzgFqOupy"
        , "content-type: application/json"
    )
    @GET("gasPrice/turkeyGasoline")
    fun getWhereToBuyFuel(@Query("district") district:String, @Query("city") city: String):Call<FuelInformation>



    @POST("markalar/")
    fun getVehicleInfo(): Call<VehicleInformation>
}
