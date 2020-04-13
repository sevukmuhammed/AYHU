package com.example.ayhu.data.repository

import android.content.Context
import android.os.AsyncTask
import com.example.ayhu.data.localdb.CarItemDAO
import com.example.ayhu.data.model.CarItem
import com.example.ayhu.infrastructure.local.room.CarDataBase

/* 
Created by Muhammed Yusuf ÇİL 
Date : 4/13/2020
*/
class CarRepository (context:Context){
    var carItemDAO: CarItemDAO? = null

    lateinit var db: CarDataBase

    fun getDataBase(context: Context) {
        db = CarDataBase.getCustom(context)!!
    }


    init {
        val db = CarDataBase.getCustom(context)
        if (db != null) {
            carItemDAO = db.carItemDAO()
        }
    }

    private class GetAllCarsInfo(
        private val dao: CarItemDAO
    ) : AsyncTask<Void, Void, List<CarItem>>() {
        override fun doInBackground(vararg p0: Void?): List<CarItem> {
            return dao.getAllCars()
        }
    }

    fun getAllData(): List<CarItem> {
        return GetAllCarsInfo(
            carItemDAO!!
        ).execute().get()
    }
}