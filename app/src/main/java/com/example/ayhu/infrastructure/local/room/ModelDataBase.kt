package com.example.ayhu.infrastructure.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.ayhu.data.localdb.ModelItemDAO
import com.example.ayhu.data.model.ModelItem
import java.util.concurrent.Executors

@Database(entities = arrayOf(ModelItem::class), version = 1)
abstract class ModelDataBase : RoomDatabase() {

    abstract fun carModelItemDAO(): ModelItemDAO

    companion object {

        private var MODEL: ModelDataBase? = null

        fun getModel(context: Context): ModelDataBase? {
            if (MODEL == null) {
                synchronized(ModelDataBase::class.java) {
                    MODEL = Room.databaseBuilder(
                        context.applicationContext,
                        ModelDataBase::class.java,
                        "model.db"
                    ).allowMainThreadQueries()
                        .addCallback(object : RoomDatabase.Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                Executors.newSingleThreadScheduledExecutor().execute {
                                    MODEL?.carModelItemDAO()!!.getAllCars(
                                    )
                                }
                            }
                        })
                        .build()
                }
            }
            return MODEL
        }

        fun getCarsModel(): List<ModelItem> {
            var cars = mutableListOf<ModelItem>()
            cars.add(ModelItem(1,"Golf"))
            cars.add(ModelItem(2,"Arteon"))
            cars.add(ModelItem(3,"Polo"))
            cars.add(ModelItem(4,"Passat"))
            cars.add(ModelItem(5,"Jetta"))
            cars.add(ModelItem(6,"Bora"))
            cars.add(ModelItem(7,"Tiguan"))
            cars.add(ModelItem(9,"Tuareg"))
            cars.add(ModelItem(10,"Schirocco"))
            cars.add(ModelItem(11,"Transporter"))
            cars.add(ModelItem(12,"Caravelle"))
            return cars
        }
    }
}
