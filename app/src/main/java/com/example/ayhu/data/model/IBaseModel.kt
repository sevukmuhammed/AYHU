package com.example.ayhu.data.model


interface IBaseModel{

    val type :Int

    companion object{
        const val TYPE_FUEL=1
        const val TYPE_VEHICLE=2
    }
}