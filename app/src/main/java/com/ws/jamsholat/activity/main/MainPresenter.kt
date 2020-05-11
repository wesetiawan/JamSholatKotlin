package com.ws.jamsholat.activity.main

import android.content.Context
import com.ws.jamsholat.activity.ui.scrolldatepick.ScrollDatePicker
import com.ws.jamsholat.model.daily.Data
import com.ws.jamsholat.model.daily.ShalatData
import com.ws.jamsholat.activity.ui.scrolldatepick.model.Calendar
import com.ws.jamsholat.activity.ui.scrolldatepick.model.DatePickerModel
import com.ws.jamsholat.network.ApiInterface
import com.ws.jamsholat.util.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(context: Context) {
    private val mainView = context as IMainView

    private var apiInterface : ApiInterface? = null

    private val month = getCurrentMonth()
    private val year = getCurrentYear()


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
            .enqueue(object : Callback<Calendar>{
                override fun onFailure(call: Call<Calendar>, t: Throwable) {
                    mainView.onCalendarErrorFromApi(t)
                }

                override fun onResponse(call: Call<Calendar>, response: Response<Calendar>) {
                    @Suppress("UNCHECKED_CAST")
                    val data = response.body()?.data as List<DatePickerModel>
                    mainView.onCalendarCompleteFromApi(data)
                }
            })
    }







}