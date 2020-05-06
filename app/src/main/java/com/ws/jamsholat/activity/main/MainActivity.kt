package com.ws.jamsholat.activity.main

import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ws.jamsholat.R
import com.ws.jamsholat.activity.ui.scrolldatepick.DatePickAdapter
import com.ws.jamsholat.activity.ui.scrolldatepick.IDatePicker
import com.ws.jamsholat.model.daily.Data
import com.ws.jamsholat.model.calendar.Calendar
import com.ws.jamsholat.model.calendar.DataItem
import com.ws.jamsholat.util.Util
import com.ws.jamsholat.util.Util.Companion.toInt
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), IMainView, IDatePicker {

    private lateinit var mainPresenter: MainPresenter
    private lateinit var datePicker: RecyclerView

    val date = Util.getCurrentDate()

    private var day = date.toInt("dd", Locale.ROOT)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        datePicker = findViewById(R.id.date_picker_scroll_day_recycler_view)

        mainPresenter = MainPresenter(this)
        mainPresenter.getDataFromApi()
        mainPresenter.getHijCalendar(datePicker)

    }

    override fun onTimingsCompleteFromApi(data: Data) {
        val time = data.timings
        val date = data.date
        val hijri = date?.hijri
        tv_informasi.text = hijTextFormat(
            hijri?.day.toString(),
            hijri?.month?.en.toString(),
            hijri?.year.toString()
        )
        tv_Imsak.text = time?.imsak
        tv_Fajr.text = time?.fajr
        tv_Dhuhr.text = time?.dhuhr
        tv_Asr.text = time?.asr
        tv_Maghrib.text = time?.maghrib
        tv_Isha.text = time?.isha
        tv_jam_menit.text = time!!.imsak
        tv_timedesc.text = "Imsyak"
    }

    override fun onTimingsErrorFromApi(throwable: Throwable) {
        Toast.makeText(this, "Error ${throwable.localizedMessage}", Toast.LENGTH_LONG).show()
    }

    override fun onCalendarCompleteFromApi(calendar: Calendar) {

    }

    override fun onCalendarErrorFromApi(throwable: Throwable) {
        Toast.makeText(this, "Error ${throwable.localizedMessage}", Toast.LENGTH_LONG).show()
    }

    override fun onLoadDate(item: DataItem, position: Int) {
        showData(item)
    }

    override fun onDateClick(item: DataItem, position: Int) {
        showData(item)
    }

    private fun showData(item: DataItem) {
        tv_Imsak.text = item.timings?.imsak.toString()
        tv_Fajr.text = item.timings?.fajr.toString()
        tv_Dhuhr.text = item.timings?.dhuhr.toString()
        tv_Asr.text = item.timings?.asr.toString()
        tv_Maghrib.text = item.timings?.maghrib.toString()
        tv_Isha.text = item.timings?.isha.toString()
    }


    private fun hijTextFormat(day: String, month: String, year: String): String {
        return "$day $month $year"
    }

}
