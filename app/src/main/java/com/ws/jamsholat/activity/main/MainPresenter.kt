package com.ws.jamsholat.activity.main

import android.content.Context
import com.ws.jamsholat.model.daily.Data
import com.ws.jamsholat.model.daily.ShalatData
import com.ws.jamsholat.model.calendar.Calendar
import com.ws.jamsholat.network.ApiInterface
import com.ws.jamsholat.util.Util
import com.ws.jamsholat.util.Util.Companion.getCurrentLatitude
import com.ws.jamsholat.util.Util.Companion.getCurrentLongitude
import com.ws.jamsholat.util.Util.Companion.getCurrentTimeMillis
import com.ws.jamsholat.util.Util.Companion.toInt
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.random.Random.Default.Companion

class MainPresenter(context: Context) {
    val mainView = context as IMainView
    var apiInterface : ApiInterface? = null
    val date = Util.getCurrentDate()

    private val month = date.toInt("MM", Locale.ROOT)
    private val year = date.toInt("YYYY", Locale.ROOT)


    fun getDataFromApi(){
        apiInterface = ApiInterface.createDaily()
        apiInterface!!.getTodayApi(getCurrentTimeMillis(),getCurrentLatitude(),getCurrentLongitude(),"5")
            .enqueue(object : Callback<ShalatData>{
                override fun onFailure(call: Call<ShalatData>, t: Throwable) {
                    mainView.onTimingsErrorFromApi(t)
                }

                override fun onResponse(call: Call<ShalatData>, response: Response<ShalatData>) {
                    mainView.onTimingsCompleteFromApi(response.body()?.data as Data)
                }

            })
    }

    fun getHijCalendar(){
        apiInterface = ApiInterface.createHijCalendar()
        apiInterface!!.getHijCalendar(getCurrentLatitude(), getCurrentLongitude(),"5", month, year)
            .enqueue(object : Callback<com.ws.jamsholat.model.calendar.Calendar>{
                override fun onFailure(call: Call<Calendar>, t: Throwable) {
                    mainView.onCalendarErrorFromApi(t)
                }

                override fun onResponse(call: Call<Calendar>, response: Response<Calendar>) {
                    response.body()?.let { mainView.onCalendarCompleteFromApi(it) }
                }

            })
    }






}