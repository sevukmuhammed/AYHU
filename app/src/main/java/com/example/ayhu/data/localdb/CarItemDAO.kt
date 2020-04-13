package com.example.ayhu.data.localdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ayhu.data.model.CarItem

@Dao
interface CarItemDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    @Query("SELECT * FROM CarItem")
    fun getAllCars(carItem:List<CarItem>)
}