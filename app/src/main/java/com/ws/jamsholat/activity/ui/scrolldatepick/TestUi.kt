package com.ws.jamsholat.activity.ui.scrolldatepick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ws.jamsholat.R
import com.ws.jamsholat.model.calendar.Calendar
import com.ws.jamsholat.model.calendar.DataItem
import com.ws.jamsholat.network.ApiInterface
import com.ws.jamsholat.util.Util
import com.ws.jamsholat.util.Util.Companion.toInt
import kotlinx.android.synthetic.main.activity_test_ui.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class TestUi : AppCompatActivity(),IDatePicker {

    var apiInterface: ApiInterface? = null
    lateinit var datePicker: RecyclerView
    private var day: Int = 0
    var selectedItemBackground = androidx.cardview.R.color.cardview_dark_background
    var unselectedItemBackground = androidx.cardview.R.color.cardview_light_background

    var secondView = 0
    var tempView = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_ui)

        datePicker = findViewById(R.id.date_picker_scroll_day_recycler_view)

        val date = Util.getCurrentDate()

        day = date.toInt("d",Locale.ROOT)
        val month = date.toInt("MM", Locale.ROOT)
        val year = date.toInt("YYYY", Locale.ROOT)

        apiInterface = ApiInterface.createHijCalendar()
        apiInterface!!.getHijCalendar(Util.getCurrentLatitude(),Util.getCurrentLongitude(),"5",month,year).enqueue(object : Callback<Calendar>{
            override fun onFailure(call: Call<Calendar>, t: Throwable) {

            }

            override fun onResponse(call: Call<Calendar>, response: Response<Calendar>) {
                @Suppress("UNCHECKED_CAST")
                dataToAdapter(response.body()?.data as List<DataItem>)

            }

        })
    }

    fun dataToAdapter(body: List<DataItem>){
        datePicker.apply {
            setHasFixedSize(true)
            setItemViewCacheSize(31)
            layoutManager = LinearLayoutManager(this@TestUi, LinearLayoutManager.HORIZONTAL, false)
            adapter = DatePickAdapter(body,day)
        }
    }

    override fun onLoadDate(item: DataItem, position: Int) {
        showData(item)
    }

    override fun onDateClick(item: DataItem, position: Int) {
        showData(item)
    }

    private fun showData(item: DataItem){
        tv_tanggal.text = item.date?.readable.toString()
        tv_Imsak.text = item.timings?.imsak.toString()
        tv_Fajr.text = item.timings?.fajr.toString()
        tv_Dhuhr.text = item.timings?.dhuhr.toString()
        tv_Asr.text = item.timings?.asr.toString()
        tv_Maghrib.text = item.timings?.maghrib.toString()
        tv_Isha.text = item.timings?.isha.toString()
    }

    private fun itemSelectedAnimation(position: Int){
        if (secondView != 0){
            tempView = secondView
            datePicker[tempView].setBackgroundColor(unselectedItemBackground)
            secondView = position
            datePicker[secondView].setBackgroundColor(selectedItemBackground)
        }else{
            secondView = position
            datePicker[position].setBackgroundColor(selectedItemBackground)

        }





    }

}
