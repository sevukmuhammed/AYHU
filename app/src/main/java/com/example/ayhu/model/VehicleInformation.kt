package com.example.ayhu.model

/* 
Created by Muhammed Yusuf ÇİL 
Date : 3/11/2020
*/
data class VehicleInformation(var brand: List<Brand>)

data class Brand(
    var make_id: Int,
    var make_name: String
)