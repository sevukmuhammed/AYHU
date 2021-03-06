package com.example.ayhu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ayhu.R
import com.example.ayhu.data.model.IBaseModel
import com.example.ayhu.viewholder.BaseViewHolder
import com.example.ayhu.viewholder.CarAddedViewHolder
import java.lang.IllegalArgumentException


class AppRecyclerViewAdapter(
    var items: MutableList<IBaseModel>,
    var recyclerViewClickListener: RecyclerViewClickListener
) : RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            IBaseModel.TYPE_FUEL ->
                CarAddedViewHolder(
                    layoutInflater.inflate(
                        R.layout.item_card_car_added,
                        parent,
                        false
                    )
                )
            else ->
                throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount()=items.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when(items[position].type) {
            IBaseModel.TYPE_FUEL ->
                (holder as CarAddedViewHolder).bindView(
                    items[position],
                    position,
                    recyclerViewClickListener
                )
        }
    }
    override fun getItemViewType(position: Int): Int { //  !!!Burayı sor!!!
        return items[position].type
    }
}