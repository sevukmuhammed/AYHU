package com.example.ayhu.dto

import android.provider.ContactsContract
import com.example.ayhu.model.BaseModel
import com.example.ayhu.model.BaseModel.Companion.TYPE_FUEL


data class FuelInfoDTO(
    var _IlceAd: String,
    var _Motorin: Float,
    var _Kursunsuz95: Float,
    var _GazYagi: Float
) : BaseModel {
    override val type: Int
        get() = TYPE_FUEL
}
