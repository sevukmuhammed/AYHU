package com.example.ayhu.model

/* 
Created by Muhammed Yusuf ÇİL 
Date : 3/10/2020
*/
data class FuelInformation(var result: List<Result>)

data class Result(
    var data:List<Data>
)
data class Data(
    var _IlceAd: String,
    var _Motorin: Float,
    var _Kursunsuz95: Float,
    var _GazYagi: Float
)