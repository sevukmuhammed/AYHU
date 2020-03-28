package com.example.ayhu.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.ayhu.R
import com.example.ayhu.dto.FuelInfoDTO
import com.example.ayhu.model.FuelInformation
import com.example.movieclone.network.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class VehicleAddingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SystemUIVisibility()
        setContentView(R.layout.activity_vehicle_adding)

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
