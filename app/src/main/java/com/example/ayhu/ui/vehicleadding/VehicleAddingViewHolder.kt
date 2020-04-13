package com.example.ayhu.ui.vehicleadding

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.ayhu.data.model.CarItem
import com.example.ayhu.data.repository.CarRepository

/* 
Created by Muhammed Yusuf ÇİL 
Date : 4/13/2020
*/
class VehicleAddingViewHolder(context:Context):ViewModel(){

    var repository = CarRepository(context)

    init {
        repository.getDataBase(context)
    }
    fun getAllData() {
        repository.getAllData()
    }
}