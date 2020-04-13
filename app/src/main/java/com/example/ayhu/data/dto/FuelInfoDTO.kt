package com.example.ayhu.data.dto

import com.example.ayhu.data.model.BaseModel
import com.example.ayhu.data.model.BaseModel.Companion.TYPE_FUEL
//askljdsadgi

data class FuelInfoDTO(
    var benzin: Float,
    var marka: String
) : BaseModel {
    override val type: Int
        get() = TYPE_FUEL
}
