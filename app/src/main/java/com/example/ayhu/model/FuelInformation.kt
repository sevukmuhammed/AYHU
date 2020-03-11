package com.example.ayhu.model


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