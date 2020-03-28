package com.example.ayhu.model

/* 
Created by Muhammed Yusuf ÇİL 
Date : 3/10/2020
*/
data class FuelInformation(var result: List<Result>)

data class Result(
    var benzin: Float,
    var marka: String
)
