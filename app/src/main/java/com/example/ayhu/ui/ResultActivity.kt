package com.example.ayhu.ui

import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ayhu.R
import com.example.ayhu.data.AppConstants
import com.example.ayhu.data.AppConstants.Companion.lat1
import com.example.ayhu.data.AppConstants.Companion.long1
import com.google.android.gms.maps.model.LatLng
import java.lang.Double.parseDouble

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var distance=distanceBetween(lat1,long1)/1000.0

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
