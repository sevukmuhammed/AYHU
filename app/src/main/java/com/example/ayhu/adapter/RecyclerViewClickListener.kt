package com.example.ayhu.adapter

import com.example.ayhu.data.model.IBaseModel

interface RecyclerViewClickListener {
    fun onClickListener(position: Int,model: IBaseModel)
    fun onLongClickListener(position: Int,model: IBaseModel)
}