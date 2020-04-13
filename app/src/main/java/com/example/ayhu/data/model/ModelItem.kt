package com.example.ayhu.data.model

@Entity(tableName = "ModelItem")
class ModelItem
    (@PrimaryKey(autoGenerate = true)
     @ColumnInfo(name = "id") val id: Int,
     @ColumnInfo(name = "modelName") val modelName: String)