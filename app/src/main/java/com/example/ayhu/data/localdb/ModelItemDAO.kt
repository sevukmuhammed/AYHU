package com.example.ayhu.data.localdb

import androidx.room.Dao
import androidx.room.Query
import com.example.ayhu.data.model.ModelItem

@Dao
interface ModelItemDAO {
    @Query("SELECT * FROM ModelItem")
    fun getAllCars(): List<ModelItem>
}