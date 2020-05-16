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
    fun getWhereToBuyFuel( @Query("city") city: String):Call<FuelInformation>
   // @Query("district") district:String
//    @GET("callback=?&cmd=getMakes&year=2000")
//    fun getVehicleBrand():Call<VehicleInformation>

}
