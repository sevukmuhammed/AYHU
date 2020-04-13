package com.example.ayhu.data.localdb

interface ModelItemDAO {
    @Query("SELECT * FROM ModelItem")
    fun getAllCars(): List<ModelItem>
}