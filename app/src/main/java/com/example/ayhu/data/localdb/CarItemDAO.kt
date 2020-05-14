package com.example.ayhu.data.localdb

import androidx.room.Dao

import androidx.room.Query
import com.example.ayhu.data.model.CarItem
import retrofit2.http.Query

@Dao
interface CarItemDAO {
    @Query("SELECT * FROM CarItem")
    fun getAllCars():List<CarItem>
}