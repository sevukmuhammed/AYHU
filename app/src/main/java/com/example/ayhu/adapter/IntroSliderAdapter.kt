package com.example.ayhu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ayhu.R
import com.example.ayhu.data.model.IntroSlideModel

/*
Created by Emre UYGUN
*/

class IntroSliderAdapter(private val introSlides: List<IntroSlideModel>):
    RecyclerView.Adapter<IntroSliderAdapter.IntroSlideViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewHolder {
        return IntroSlideViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slider_item_container,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return introSlides.size
    }

    override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
        holder.bind(introSlides[position])
    }

    inner class IntroSlideViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val textTitle = view.findViewById<TextView>(R.id.txt_title)
        private val textDescription = view.findViewById<TextView>(R.id.txt_description)
        private val imageIcon = view.findViewById<ImageView>(R.id.imgView_SlideIcon)

        fun bind(introSlide: IntroSlideModel){
            textTitle.text = introSlide.tittle
            textDescription.text = introSlide.description
            imageIcon.setImageResource(introSlide.icon)
        }
    }
}