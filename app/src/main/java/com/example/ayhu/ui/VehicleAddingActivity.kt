package com.example.ayhu.ui

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
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.ayhu.MapsActivity
import com.example.ayhu.data.model.VehicleInformation
import com.example.ayhu.network.VehicleRetrofitFactory
import com.example.movieclone.networkvaRretA.FuelRetrofitFactory
import com.toptoche.searchablespinnerlibrary.SearchableSpinner

/*
Created by Emre UYGUN
*/

class VehicleAddingActivity : AppCompatActivity() {
    lateinit var arrayModel:Array<String?>
    lateinit var arrayPackages:Array<String?>
    lateinit var arrayAdapter:ArrayAdapter<String?>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        systemUIVisibility()
        setContentView(R.layout.activity_vehicle_adding)
        goBackButton()
        btn_vehicle_save.setOnClickListener {
            var intent=Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
        var innerModel=0
        var innerPackages=0

        val spinnerBrand=findViewById<Spinner>(R.id.sp_brand_choose) as SearchableSpinner
        val spinnerModel=findViewById<Spinner>(R.id.sp_model_choose) as SearchableSpinner
        val spinnerPackage=findViewById<Spinner>(R.id.sp_package_choose) as SearchableSpinner

        var arrayBrand=resources.getStringArray(R.array.brands)
        arrayAdapter= ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,arrayBrand)
        spinnerBrand.adapter=arrayAdapter

        //Bu if kaldırabilir
        spinnerBrand.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                if(innerModel==1){
                    getModeltoBrand(arrayBrand[position])
                    if (view != null) {
                        arrayAdapter=ArrayAdapter(view.context,android.R.layout.simple_spinner_dropdown_item,arrayModel)
                        spinnerModel.adapter=arrayAdapter
                        spinnerModel.visibility=View.VISIBLE
                    }
                }else
                    innerModel=1


//                    Log.d("Seçilen marka",arrayBrand[position])

            }


        }

        spinnerModel.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if(innerPackages==1){
                    arrayModel[position]?.let { getPackagestoModel(it) }
                    if (view != null) {
                        arrayAdapter=ArrayAdapter(view.context,android.R.layout.simple_spinner_dropdown_item,arrayPackages)
                        spinnerPackage.adapter=arrayAdapter
                        spinnerPackage.visibility=View.VISIBLE
                    }
                }else
                    innerPackages=1
            }

        }
    }

    private fun systemUIVisibility(){
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

    private fun goBackButton(){
        goBack1.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    fun getModeltoBrand(returnInfo:String){

        when(returnInfo){
            "ALFA ROMEO"->{
                arrayModel=resources.getStringArray(R.array.model_alfa_romeo)
            }
            "ASTON MARTIN"->{
                arrayModel=resources.getStringArray(R.array.model_aston_martin)
            }
            "AUDI"->{
                arrayModel=resources.getStringArray(R.array.model_audi)
            }
            "BENTLEY"->{
                arrayModel=resources.getStringArray(R.array.model_bentley)
            }
            "BMW"->{
                arrayModel=resources.getStringArray(R.array.model_bmw)
            }
            "CADILLAC"->{
                arrayModel=resources.getStringArray(R.array.model_cadillac)
            }
            "CHEVROLET"->{
                arrayModel=resources.getStringArray(R.array.model_chevrolet)
            }
            "CITROEN"->{
                arrayModel=resources.getStringArray(R.array.model_citroen)
            }
            "DACIA"->{
                arrayModel=resources.getStringArray(R.array.model_dacia)
            }
            "FERRARI"->{
                arrayModel=resources.getStringArray(R.array.model_ferrari)
            }
            "FIAT"->{
                arrayModel=resources.getStringArray(R.array.model_fiat)
            }
            "FORD"->{
                arrayModel=resources.getStringArray(R.array.model_ford)
            }
            "HONDA"->{
                arrayModel=resources.getStringArray(R.array.model_honda)
            }
            "HYUNDAI"->{
                arrayModel=resources.getStringArray(R.array.model_hyundai)
            }
            "KIA"->{
                arrayModel=resources.getStringArray(R.array.model_kia)
            }
        }

    }

    fun getPackagestoModel(returnInfo: String){

        when(returnInfo){

            //Alfa Romeo
            "GIULIA"->{
                arrayPackages=resources.getStringArray(R.array.package_giulia)
            }
            "GIULIETTA"->{
                arrayPackages=resources.getStringArray(R.array.package_giulietta)
            }
            "145"->{
                arrayPackages=resources.getStringArray(R.array.package_145)
            }
            "146"->{
                arrayPackages=resources.getStringArray(R.array.package_146)
            }
            "147"->{
                arrayPackages=resources.getStringArray(R.array.package_147)
            }

            //Aston Martin
            "DB11"->{
                arrayPackages=resources.getStringArray(R.array.package_db11)
            }
            "VANTAGE"->{
                arrayPackages=resources.getStringArray(R.array.package_vantage)
            }
            "CYGNET"->{
                arrayPackages=resources.getStringArray(R.array.package_cygnet)
            }
            "DB7"->{
                arrayPackages=resources.getStringArray(R.array.package_db7)
            }
            "DB9"->{
                arrayPackages=resources.getStringArray(R.array.package_db9)
            }

            //Audi
            "A1"->{
                arrayPackages=resources.getStringArray(R.array.package_a1)
            }
            "A3"->{
                arrayPackages=resources.getStringArray(R.array.package_a3)
            }
            "A4"->{
                arrayPackages=resources.getStringArray(R.array.package_a4)
            }
            "A5"->{
                arrayPackages=resources.getStringArray(R.array.package_a5)
            }
            "A6"->{
                arrayPackages=resources.getStringArray(R.array.package_a6)
            }

            //Bentley
            "CONTINENTAL"->{
                arrayPackages=resources.getStringArray(R.array.package_continental)
            }
            "FLYING SPUR"->{
                arrayPackages=resources.getStringArray(R.array.package_flying_spur)
            }
            "BROOKLANDS"->{
                arrayPackages=resources.getStringArray(R.array.package_brooklands)
            }
            "MULSANNE"->{
                arrayPackages=resources.getStringArray(R.array.package_mulsanne)
            }

            //BMW
            "1 SERIES"->{
                arrayPackages=resources.getStringArray(R.array.package_1_series)
            }
            "2 SERIES"->{
                arrayPackages=resources.getStringArray(R.array.package_2_series)
            }
            "3 SERIES"->{
                arrayPackages=resources.getStringArray(R.array.package_3_series)
            }
            "M SERIES"->{
                arrayPackages=resources.getStringArray(R.array.package_m_series)
            }
            "Z SERIES"->{
                arrayPackages=resources.getStringArray(R.array.package_z_series)
            }

            //Cadillac
            "CTS"->{
                arrayPackages=resources.getStringArray(R.array.package_cts)
            }
            "BROUGHAM"->{
                arrayPackages=resources.getStringArray(R.array.package_brougham)
            }
            "DEVILLE"->{
                arrayPackages=resources.getStringArray(R.array.package_deville)
            }
            "ELDORADO"->{
                arrayPackages=resources.getStringArray(R.array.package_eldorado)
            }
            "FLEETWOOD"->{
                arrayPackages=resources.getStringArray(R.array.package_fleetwood)
            }

            //Chevrolet
            "AVEO"->{
                arrayPackages=resources.getStringArray(R.array.package_aveo)
            }
            "CAMARO"->{
                arrayPackages=resources.getStringArray(R.array.package_camaro)
            }
            "CORVETTE"->{
                arrayPackages=resources.getStringArray(R.array.package_corvette)
            }
            "CRUZE"->{
                arrayPackages=resources.getStringArray(R.array.package_cruze)
            }
            "EPICA"->{
                arrayPackages=resources.getStringArray(R.array.package_epica)
            }

            //Citroen
            "C1"->{
                arrayPackages=resources.getStringArray(R.array.package_c1)
            }
            "C2"->{
                arrayPackages=resources.getStringArray(R.array.package_c2)
            }
            "C3"->{
                arrayPackages=resources.getStringArray(R.array.package_c3)
            }
            "C3 PICASSO"->{
                arrayPackages=resources.getStringArray(R.array.package_c3_picasso)
            }
            "C4"->{
                arrayPackages=resources.getStringArray(R.array.package_c4)
            }

            //Dacia
            "LODGY"->{
                arrayPackages=resources.getStringArray(R.array.package_lodgy)
            }
            "LOGAN"->{
                arrayPackages=resources.getStringArray(R.array.package_logan)
            }
            "SANDERO"->{
                arrayPackages=resources.getStringArray(R.array.package_sandero)
            }
            "SOLENZA"->{
                arrayPackages=resources.getStringArray(R.array.package_solenza)
            }

            //Ferrari
            "458"->{
                arrayPackages=resources.getStringArray(R.array.package_458)
            }
            "488"->{
                arrayPackages=resources.getStringArray(R.array.package_488)
            }
            "599"->{
                arrayPackages=resources.getStringArray(R.array.package_599)
            }
            "812"->{
                arrayPackages=resources.getStringArray(R.array.package_812)
            }
            "CALIFORNIA"->{
                arrayPackages=resources.getStringArray(R.array.package_california)
            }

            //Fiat
            "124 SPIDER"->{
                arrayPackages=resources.getStringArray(R.array.package_124_spider)
            }
            "500 FAMILY"->{
                arrayPackages=resources.getStringArray(R.array.package_500_family)
            }
            "ALBEA"->{
                arrayPackages=resources.getStringArray(R.array.package_albea)
            }
            "BRAVO"->{
                arrayPackages=resources.getStringArray(R.array.package_bravo)
            }
            "EGEA"->{
                arrayPackages=resources.getStringArray(R.array.package_egea)
            }

            //Ford
            "B-MAX"->{
                arrayPackages=resources.getStringArray(R.array.package_b_max)
            }
            "C-MAX"->{
                arrayPackages=resources.getStringArray(R.array.package_c_max)
            }
            "ESCORT"->{
                arrayPackages=resources.getStringArray(R.array.package_escort)
            }
            "FIESTA"->{
                arrayPackages=resources.getStringArray(R.array.package_fiesta)
            }
            "FOCUS"->{
                arrayPackages=resources.getStringArray(R.array.package_focus)
            }

            //Honda
            "ACCORD"->{
                arrayPackages=resources.getStringArray(R.array.package_accord)
            }
            "CITY"->{
                arrayPackages=resources.getStringArray(R.array.package_city)
            }
            "CIVIC"->{
                arrayPackages=resources.getStringArray(R.array.package_civic)
            }
            "CR-Z"->{
                arrayPackages=resources.getStringArray(R.array.package_cr_z)
            }
            "JAZZ"->{
                arrayPackages=resources.getStringArray(R.array.package_jazz)
            }

            //Hyundai
            "ACCENT"->{
                arrayPackages=resources.getStringArray(R.array.package_accent)
            }
            "ACCENT BLUE"->{
                arrayPackages=resources.getStringArray(R.array.package_accent_blue)
            }
            "ACCENT ERA"->{
                arrayPackages=resources.getStringArray(R.array.package_accent_era)
            }
            "ATOS"->{
                arrayPackages=resources.getStringArray(R.array.package_atos)
            }
            "ELENTRA"->{
                arrayPackages=resources.getStringArray(R.array.package_elentra)
            }

            //Kia
            "CEED"->{
                arrayPackages=resources.getStringArray(R.array.package_ceed)
            }
            "CERATO"->{
                arrayPackages=resources.getStringArray(R.array.package_cerato)
            }
            "PICANTO"->{
                arrayPackages=resources.getStringArray(R.array.package_picanto)
            }
            "PRO CEED"->{
                arrayPackages=resources.getStringArray(R.array.package_pro_ceed)
            }
            "RIO"->{
                arrayPackages=resources.getStringArray(R.array.package_rio)
            }
        }

    }
}
