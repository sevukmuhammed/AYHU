package com.example.ayhu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ayhu.R
import com.example.ayhu.model.BaseModel
import com.example.ayhu.viewholder.BaseViewHolder

/* 
Created by Muhammed Yusuf ÇİL 
Date : 3/10/2020
*/
class AppRecyclerViewAdapter(
    var items: MutableList<BaseModel>,
    var recyclerViewClickListener: RecyclerViewClickListener
):RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return when(viewType){
            BaseModel.TYPE_FUEL->
                layoutInflater.inflate(
                    R.layout.
                )
        }
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}