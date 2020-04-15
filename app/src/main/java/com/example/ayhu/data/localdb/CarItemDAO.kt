package com.example.ayhu.data.localdb

import androidx.room.Dao

import androidx.room.Query
import com.example.ayhu.data.model.CarItem

@Dao
interface CarItemDAO {
    @Query("SELECT * FROM CarItem")
    fun getAllCars():List<CarItem>
}