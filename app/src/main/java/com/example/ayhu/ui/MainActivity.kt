package com.example.ayhu.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.ayhu.R
import com.example.ayhu.adapter.IntroSliderAdapter
import com.example.ayhu.model.FuelInformation
import com.example.ayhu.model.VehicleInformation
import com.example.ayhu.network.RetrofitVehicleFactory
import com.example.movieclone.network.RetrofitFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.onboarding_screens.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)








//                val apiVehicleService= RetrofitVehicleFactory.getVehicleInformation().getVehicleInfo()
//        apiVehicleService.enqueue(object : Callback<VehicleInformation>{
//            override fun onFailure(call: Call<VehicleInformation>, t: Throwable) {
//                Log.d("başarısız","başarısız")
//            }
//            override fun onResponse(
//                call: Call<VehicleInformation>,
//                response: Response<VehicleInformation>
//            ){
//                Log.d("Başarılı","Başarılı")
//            }
//        })


        cv_vehicle_adding.setOnClickListener {
            var intent:Intent= Intent(this,VehicleAddingActivity::class.java)
            startActivity(intent)
        }
    }

    fun SystemUIVisibility(){
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}
