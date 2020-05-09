package com.example.ayhu.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ayhu.adapter.RecyclerViewClickListener
import com.example.ayhu.data.model.IBaseModel


abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bindView(baseModel: IBaseModel, position: Int, click: RecyclerViewClickListener)
}