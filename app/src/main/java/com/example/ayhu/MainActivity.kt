package com.example.ayhu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ayhu.model.FuelInformation
import com.example.movieclone.network.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
    }
}
