package com.example.ayhu.model


data class FuelInformation(var result: List<Result>)

data class Result(
    var benzin: Float,
    var marka: String
)
