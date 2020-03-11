package com.example.ayhu.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.ayhu.R
import com.example.ayhu.model.FuelInformation
import com.example.movieclone.network.RetrofitFactory
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SystemUIVisibility()
        setContentView(R.layout.activity_main)

        val apiService = RetrofitFactory.getFuelInformation()
            .getFuelInfo("Ankara")//kullanicidan alınacak değer
        apiService.enqueue(object : Callback<FuelInformation>{
            override fun onFailure(call: Call<FuelInformation>, t: Throwable) {
                Log.d("Başarısız","Başarısız")
            }
            override fun onResponse(
                call: Call<FuelInformation>,
                response: Response<FuelInformation>
            ) {
                Log.d("Başarılı","Başarılı")
            }
        })

        cv_vehicle_adding.setOnClickListener {
            val intent = Intent(this, VehicleAddingActivity::class.java)
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
