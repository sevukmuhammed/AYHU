package com.example.ayhu.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/* 
Created by Muhammed Yusuf ÇİL 
Date : 4/13/2020
*/
@Entity(tableName = "CarItem")
class CarItem(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "carName") val carName: String
)
