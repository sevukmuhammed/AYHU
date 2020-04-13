package com.example.ayhu.dto

import android.provider.ContactsContract
import com.example.ayhu.model.BaseModel
import com.example.ayhu.model.BaseModel.Companion.TYPE_FUEL
//askljdsadgi

data class FuelInfoDTO(
    var benzin: Float,
    var marka: String
) : BaseModel {
    override val type: Int
        get() = TYPE_FUEL
}
