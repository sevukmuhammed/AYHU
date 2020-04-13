package com.example.ayhu.ui

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.example.ayhu.R
import com.example.ayhu.adapter.IntroSliderAdapter
import com.example.ayhu.data.model.IntroSlideModel
import kotlinx.android.synthetic.main.onboarding_screens.*

/*
Created by Emre UYGUN
*/

class IntroSlideActivity: AppCompatActivity() {

    private val introSliderAdapter = IntroSliderAdapter(
        listOf(
            IntroSlideModel(
                "Gas Price",
                "Gas Price",
                R.drawable.android_logo
            ),
            IntroSlideModel(
                "Location",
                "Location",
                R.drawable.android_logo
            ),
            IntroSlideModel(
                "Calculate",
                "Calculate",
                R.drawable.android_logo
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_screens)
        viewPager_introSlide.adapter = introSliderAdapter
        setupIndicators()
        setCurrentIndicator(0)
        viewPager_introSlide.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        btn_Next.setOnClickListener{
            if (viewPager_introSlide.currentItem + 1 < introSliderAdapter.itemCount){
                viewPager_introSlide.currentItem += 1
            }else{
                Intent(applicationContext, MainActivity::class.java).also {
                    startActivity(it)
                }

            }
           txt_skipIntro.setOnClickListener{
               Intent(applicationContext, MainActivity::class.java).also {
                   startActivity(it)
               }
           }
        }
    }
    // version

    private fun setupIndicators() {
        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            linear_Indicators.addView(indicators[i])
        }

    }

    private fun setCurrentIndicator(index: Int){
        val childCount = linear_Indicators.childCount
        for (i in 0 until childCount){
            val imageView = linear_Indicators[i] as ImageView
            if (i == index){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }
}