package com.example.ayhu.infrastructure.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.ayhu.data.localdb.CarItemDAO
import com.example.ayhu.data.model.CarItem
import java.util.concurrent.Executors

/* 
Created by Muhammed Yusuf ÇİL 
Date : 4/13/2020
*/

@Database(entities = arrayOf(CarItem::class), version = 1)
abstract class CarDataBase : RoomDatabase() {

    abstract fun carItemDAO(): CarItemDAO

    companion object {

        private var CUSTOM: CarDataBase? = null

        fun getCustom(context: Context): CarDataBase? {
            if (CUSTOM == null) {
                synchronized(CarDataBase::class.java) {
                    CUSTOM = Room.databaseBuilder(
                        context.applicationContext,
                        CarDataBase::class.java,
                        "bus.db"
                    ).allowMainThreadQueries()
                        .addCallback(object : RoomDatabase.Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                Executors.newSingleThreadScheduledExecutor().execute {
                                    CUSTOM?.carItemDAO()!!.getAllCars(
                                    )
                                }
                            }
                        })
                        .build()
                }
            }
            return CUSTOM
        }

        fun getCarsBrand(): List<CarItem> {
            var cars = mutableListOf<CarItem>()
            cars.add(CarItem(1,"VolsWagen"))
            cars.add(CarItem(2,"Mercedes"))
            cars.add(CarItem(3,"Opel"))
            cars.add(CarItem(4,"Pegeout"))
            cars.add(CarItem(5,"Renault"))
            cars.add(CarItem(6,"BMW"))
            cars.add(CarItem(7,"FIAT"))
            cars.add(CarItem(9,"Ford"))
            cars.add(CarItem(10,"Toyota"))
            cars.add(CarItem(11,"Mıtsubishi"))
            cars.add(CarItem(12,"Aston Martin"))
            cars.add(CarItem(13,"Honda"))
            cars.add(CarItem(14,"AUDI"))
            cars.add(CarItem(15,"SEAT"))
            return cars
        }
    }
}
