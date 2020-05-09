package com.example.ayhu.data.model


data class VehicleInformation(var Makes: List<Brand>)

data class Brand(
    var make_id: Int,
    var make_display: String,
    var make_is_common:String,
    var make_country:String
)