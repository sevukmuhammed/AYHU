package com.example.ayhu.ui.vehicleadding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.ayhu.R
import com.example.ayhu.data.dto.FuelInfoDTO
import com.example.ayhu.data.model.FuelInformation
import kotlinx.android.synthetic.main.activity_vehicle_adding.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.Intent
import android.widget.Toast
import com.example.ayhu.data.model.VehicleInformation
import com.example.ayhu.network.VehicleRetrofitFactory
import com.example.ayhu.ui.MainActivity
import com.example.movieclone.networkvaRretA.FuelRetrofitFactory

/*
Created by Emre UYGUN
*/

class VehicleAddingActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SystemUIVisibility()
        setContentView(R.layout.activity_vehicle_adding)
        getVehicleApiInformation()
        val apiService = FuelRetrofitFactory.getFuelInformation()
            .getWhereToBuyFuel("kadikoy", "istanbul")//kullanicidan alınacak değer

        apiService.enqueue(object : Callback<FuelInformation> {
            override fun onFailure(call: Call<FuelInformation>, t: Throwable) {
                Log.d("Başarısız","Başarısız")
            }
            override fun onResponse(
                call: Call<FuelInformation>,
                response: Response<FuelInformation>
            ) {
                Log.d("Başarılı","Başarılı")
                response.body()?.result?.forEach {
                    var fuelInfoDTO:FuelInfoDTO= FuelInfoDTO(
                        benzin = it.benzin,
                        marka = it.marka
                    )
                    Log.d("marka",it.marka)
                }
            }
        })
        goBackButton()
    }

    fun getVehicleApiInformation(){
        val vehicleApiService=VehicleRetrofitFactory.getFuelInformation().getVehicleBrand()
        vehicleApiService.enqueue(object :Callback<VehicleInformation>{
            override fun onFailure(call: Call<VehicleInformation>, t: Throwable) {
                Log.d("Başarısız","Başarısız")
            }
            override fun onResponse(
                call: Call<VehicleInformation>,
                response: Response<VehicleInformation>
            ) {
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

    fun goBackButton(){
        goBack1.setOnClickListener {
            var intent:Intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
