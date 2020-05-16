package com.example.ayhu

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.ayhu.data.AppConstants.Companion.lat1
import com.example.ayhu.data.AppConstants.Companion.long1
import com.example.ayhu.ui.ResultActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*
import java.io.IOException

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    var dizi =ArrayList<LatLng>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        zoom.setOnZoomOutClickListener { mMap!!.animateCamera(CameraUpdateFactory.zoomOut()) }
        zoom.setOnZoomInClickListener { mMap!!.animateCamera(CameraUpdateFactory.zoomIn()) }

        btn_Uydu.setOnClickListener {
            if (mMap!!.mapType == GoogleMap.MAP_TYPE_NORMAL) {
                mMap!!.mapType = GoogleMap.MAP_TYPE_SATELLITE
                btn_Uydu.text = "Özel"
            } else {
                mMap!!.mapType = GoogleMap.MAP_TYPE_NORMAL
                btn_Uydu.text = "Uydu"
            }
        }

        btn_Git.setOnClickListener {
            val location = edt_location.text.toString()
            val location1=edt_location.text.toString()
            if (location != "") {
                var adressList: List<Address>? = null
                val geocoder = Geocoder(this@MapsActivity)
                try {
                    adressList = geocoder.getFromLocationName(location, 2)
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                val address = adressList!![0]
                val latLng = LatLng(address.latitude, address.longitude)
                mMap!!.addMarker(MarkerOptions().position(latLng).title("$location"))
                mMap!!.animateCamera(CameraUpdateFactory.newLatLng(latLng))
                dizi.add(latLng)
                Log.d("asdf",address.toString())
                Log.d("asd",dizi.toString())
            }
            btn_calculate.setOnClickListener {
                val intent = Intent(this, ResultActivity::class.java)
                lat1=dizi[0]
                long1=dizi[1]
                Log.d("mami",lat1.toString())
                Log.d("mami",long1.toString())

                startActivity(intent)
                finish()
            }
        }
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val turkey = LatLng(39.925533, 32.866287)
        mMap.addMarker(MarkerOptions().position(turkey).title("TÜRKİYE"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(turkey))

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            mMap!!.isMyLocationEnabled = true
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), MapsActivity.REQUEST_lOCATION)
            }
        }

      /*  try {
            val success = googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                    this, R.raw.maps))

            if (!success) {
                Log.e("MapsActivity", "Style parsing failed.")
            }
        } catch (e: Resources.NotFoundException) {
            Log.e("MapsActivity", "Can't find style. Error: ", e)
        }*/

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == REQUEST_lOCATION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    mMap!!.isMyLocationEnabled = true
                }
            } else {
                Toast.makeText(applicationContext, "Konum izni verilmedi.", Toast.LENGTH_SHORT).show()
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
    companion object {
        const val REQUEST_lOCATION = 90
    }
}
/*class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        try {

            val success = googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                this,R.raw.maps
                )
            )

            if (!success) {
                Log.e("MapsActivity", "Style parsing failed.")
            }
        } catch (e: Resources.NotFoundException) {
            Log.e("MapsActivity", "Can't find style. Error: ", e)
        }
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
*/