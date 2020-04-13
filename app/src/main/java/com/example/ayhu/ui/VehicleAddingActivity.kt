package com.example.ayhu.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.ayhu.R
import com.example.ayhu.dto.FuelInfoDTO
import com.example.ayhu.model.FuelInformation
import com.example.movieclone.network.RetrofitFactory
import kotlinx.android.synthetic.main.activity_vehicle_adding.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.Intent

/*
Created by Emre UYGUN
*/

class VehicleAddingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SystemUIVisibility()
        setContentView(R.layout.activity_vehicle_adding)

<<<<<<< HEAD
=======

>>>>>>> 58de824f924fc4bab8be403717472b1b9e7ce63b
        val apiService = RetrofitFactory.getFuelInformation()
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
<<<<<<< HEAD
=======
        goBackButton()

//        val apiService=RetrofitVehicleFactory.getVehicleInformation().getVehicleInfo()
////        apiService.enqueue(object : Callback<VehicleInformation>{
////            override fun onFailure(call: Call<VehicleInformation>, t: Throwable) {
////                Log.d("başarısız","başarısız")
////            }
////            override fun onResponse(
////                call: Call<VehicleInformation>,
////                response: Response<VehicleInformation>
////            ){
////                Log.d("Başarılı","Başarılı")
////            }
////        })

//-asdsa
>>>>>>> 58de824f924fc4bab8be403717472b1b9e7ce63b
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
            var intent:Intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
