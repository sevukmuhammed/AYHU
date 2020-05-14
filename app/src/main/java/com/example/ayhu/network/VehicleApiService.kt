package com.example.ayhu.network

import com.example.ayhu.data.model.VehicleInformation
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

/*
  Created by Muhammed Yusuf ÇİL
  25.04.2020 - 17:25    
  myusufcl7@gmail.com
*/      
interface VehicleApiService{

    @GET("callback=?&cmd=getMakes&year=2000")
    fun getVehicleBrand(): Call<VehicleInformation>
}