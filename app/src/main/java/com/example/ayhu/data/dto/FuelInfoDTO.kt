package com.example.ayhu.data.dto

import com.example.ayhu.data.model.IBaseModel
import com.example.ayhu.data.model.IBaseModel.Companion.TYPE_FUEL
//askljdsadgi

data class FuelInfoDTO(
    var benzin: Float,
    var marka: String
) : IBaseModel {
    override val type: Int
        get() = TYPE_FUEL
}
