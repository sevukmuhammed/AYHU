package com.example.ayhu.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.ayhu.R
import com.example.ayhu.model.VehicleInformation
import com.example.ayhu.network.RetrofitVehicleFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VehicleAddingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SystemUIVisibility()
        setContentView(R.layout.activity_vehicle_adding)
        val apiService=RetrofitVehicleFactory.getVehicleInformation().getVehicleInfo()
        apiService.enqueue(object : Callback<VehicleInformation>{
            override fun onFailure(call: Call<VehicleInformation>, t: Throwable) {
                Log.d("başarısız","başarısız")
            }
            override fun onResponse(
                call: Call<VehicleInformation>,
                response: Response<VehicleInformation>
            ){
                Log.d("Başarılı","Başarılı")
            }
        })
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
