package com.ws.jamsholat.activity.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ws.jamsholat.R
import com.ws.jamsholat.activity.ui.scrolldatepick.ScrollDatePicker
import com.ws.jamsholat.activity.ui.scrolldatepick.model.DatePickerModel
import com.ws.jamsholat.model.daily.Data
import com.ws.jamsholat.util.hijTextFormat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IMainView, ScrollDatePicker.OnDateChangedListener{

    private lateinit var mainPresenter: MainPresenter
    private lateinit var scrollDatePicker: ScrollDatePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scrollDatePicker = findViewById(R.id.sdc_main)

        mainPresenter = MainPresenter(this)

        mainPresenter.getDataFromApi()
        mainPresenter.getHijCalendar()

    }

    override fun onLoadDataFromAPi() {

    }

    override fun onTimingsCompleteFromApi(data: Data) {
        val date = data.date?.hijri
        tv_informasi.text = hijTextFormat(
            date?.day.toString(),
            date?.month?.en.toString(),
            date?.year.toString()
        )
        tv_jam_menit.text = data.timings?.imsak.toString()

    }

    override fun onTimingsErrorFromApi(throwable: Throwable) {
        Toast.makeText(this, "Error ${throwable.localizedMessage}", Toast.LENGTH_LONG).show()
    }

    override fun onCalendarCompleteFromApi(dataItem: List<DatePickerModel>) {
        scrollDatePicker.setData(dataItem)
        scrollDatePicker.show()
        scrollDatePicker.onDateChangedListener(this)
    }

    override fun onCalendarErrorFromApi(throwable: Throwable) {
        Toast.makeText(this, "Error ${throwable.localizedMessage}", Toast.LENGTH_LONG).show()
    }


    private fun showData(item: DatePickerModel) {
        tv_Imsak.text = item.timings?.imsak.toString()
        tv_Fajr.text = item.timings?.fajr.toString()
        tv_Dhuhr.text = item.timings?.dhuhr.toString()
        tv_Asr.text = item.timings?.asr.toString()
        tv_Maghrib.text = item.timings?.maghrib.toString()
        tv_Isha.text = item.timings?.isha.toString()
    }

    override fun onChanged(dataItem: DatePickerModel) {
        showData(dataItem)
    }


}
