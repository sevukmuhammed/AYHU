package com.example.ayhu.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ayhu.adapter.RecyclerViewClickListener
import com.example.ayhu.model.BaseModel

/* 
Created by Muhammed Yusuf ÇİL 
Date : 3/10/2020
*/
abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bindView(baseModel: BaseModel, position: Int, click: RecyclerViewClickListener)
}