package com.example.ayhu.ui

import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ayhu.R
import com.example.ayhu.data.AppConstants.Companion.lat1
import com.example.ayhu.data.AppConstants.Companion.long1
import com.example.ayhu.data.dto.FuelInfoDTO
import com.example.ayhu.data.model.FuelInformation
import com.example.movieclone.networkvaRretA.FuelRetrofitFactory
import com.google.android.gms.maps.model.LatLng
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var distance=distanceBetween(lat1,long1)/1000.0
        var latLng1:LatLng= LatLng(39.925533, 32.866287)
        if (lat1==null && long1==null){
            lat1=latLng1
            long1= latLng1
        }else{
            var distance=distanceBetween(lat1,long1)/1000.0
        }
        val name = intent.getStringExtra("sehir")

        val apiService = FuelRetrofitFactory.getFuelInformation()
            .getWhereToBuyFuel( name)//kullanicidan alınacak değer

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
                    var fuelInfoDTO= FuelInfoDTO(
                        benzin = it.benzin,
                        marka = it.marka
                    )
                    Log.d("marka",it.marka)
                }
            }
        })
    }
    private fun distanceBetween(latLng1: LatLng, latLng2: LatLng): Float {
        val loc1 = Location(LocationManager.GPS_PROVIDER)
        val loc2 = Location(LocationManager.GPS_PROVIDER)
        loc1.latitude = latLng1.latitude
        loc1.longitude = latLng1.longitude
        loc2.latitude = latLng2.latitude
        loc2.longitude = latLng2.longitude
        return loc1.distanceTo(loc2)
    }
}
