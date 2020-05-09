package com.example.ayhu.data.dto

import com.example.ayhu.data.model.IBaseModel
import com.example.ayhu.data.model.IBaseModel.Companion.TYPE_VEHICLE

/*
  Created by Muhammed Yusuf ÇİL
  25.04.2020 - 15:47    
  myusufcl7@gmail.com
*/

data class VehicleDTO(
    var make_id: Int,
    var make_display: String,
    var make_is_common: String,
    var make_country: String
):IBaseModel {
    override val type: Int
        get() = TYPE_VEHICLE
}
