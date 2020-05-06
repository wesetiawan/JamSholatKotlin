package com.ws.jamsholat.activity.main

import android.content.Context
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ws.jamsholat.activity.ui.scrolldatepick.DatePickAdapter
import com.ws.jamsholat.model.daily.Data
import com.ws.jamsholat.model.daily.ShalatData
import com.ws.jamsholat.model.calendar.Calendar
import com.ws.jamsholat.model.calendar.DataItem
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

class MainPresenter(context: Context) {
    val mainView = context as IMainView
    var apiInterface : ApiInterface? = null

    val date = Util.getCurrentDate()

    private var day = date.toInt("dd",Locale.ROOT)
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

    fun getHijCalendar(recyclerView: RecyclerView){
        apiInterface = ApiInterface.createHijCalendar()
        apiInterface!!.getHijCalendar(getCurrentLatitude(), getCurrentLongitude(),"5", month, year)
            .enqueue(object : Callback<com.ws.jamsholat.model.calendar.Calendar>{
                override fun onFailure(call: Call<Calendar>, t: Throwable) {
                    mainView.onCalendarErrorFromApi(t)
                }

                override fun onResponse(call: Call<Calendar>, response: Response<Calendar>) {
                    @Suppress("UNCHECKED_CAST")
                    dataToAdapter(response.body()?.data as List<DataItem>,recyclerView)
                }

            })
    }

    private fun dataToAdapter(body: List<DataItem>, recyclerView: RecyclerView) {
        recyclerView.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = DatePickAdapter(body, day)
        }
    }






}