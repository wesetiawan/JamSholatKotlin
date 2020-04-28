package com.ws.jamsholat.main

import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.location.LocationManager
import androidx.core.content.ContextCompat.getSystemService
import com.ws.jamsholat.model.Data
import com.ws.jamsholat.model.ShalatData
import com.ws.jamsholat.model.Timings
import com.ws.jamsholat.network.ApiInterface
import com.ws.jamsholat.util.Util.Companion.getCurrentLatitude
import com.ws.jamsholat.util.Util.Companion.getCurrentLongitude
import com.ws.jamsholat.util.Util.Companion.getCurrentTime
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(context: Context) {
    val mainView = context as IMainView


    fun getDataFromApi(){

        ApiInterface.create()
            .getApi(getCurrentTime(),getCurrentLatitude(),getCurrentLongitude(),"5")
            .enqueue(object : Callback<ShalatData>{
                override fun onFailure(call: Call<ShalatData>, t: Throwable) {
                    mainView.onDataErrorFromApi(t)
                }

                override fun onResponse(call: Call<ShalatData>, response: Response<ShalatData>) {
                    mainView.onDataCompleteFromApi(response.body()?.data as Data)
                }

            })
    }






}