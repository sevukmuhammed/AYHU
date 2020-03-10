package com.example.ayhu.adapter

import com.example.ayhu.model.BaseModel

/* 
Created by Muhammed Yusuf ÇİL 
Date : 3/10/2020
*/
interface RecyclerViewClickListener {
    fun onClickListener(position: Int,model: BaseModel)
    fun onLongClickListener(position: Int,model: BaseModel)
}