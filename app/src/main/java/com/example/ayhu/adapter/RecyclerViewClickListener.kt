package com.example.ayhu.adapter

import com.example.ayhu.data.model.BaseModel

interface RecyclerViewClickListener {
    fun onClickListener(position: Int,model: BaseModel)
    fun onLongClickListener(position: Int,model: BaseModel)
}