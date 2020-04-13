package com.example.ayhu.data.model


data class VehicleInformation(var brand: List<Brand>)

data class Brand(
    var make_id: Int,
    var make_name: String
)