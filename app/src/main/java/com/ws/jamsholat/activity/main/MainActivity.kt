package com.ws.jamsholat.activity.main

import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ws.jamsholat.R
import com.ws.jamsholat.model.daily.Data
import com.ws.jamsholat.model.calendar.Calendar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IMainView{

    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)
        mainPresenter.getDataFromApi()
        mainPresenter.getHijCalendar()

    }

    override fun onTimingsCompleteFromApi(data: Data) {
        val time = data.timings
        val date = data.date
        val hijri = date?.hijri
        tv_informasi.text = hijriTextFormat(hijri?.day.toString(),hijri?.month?.en.toString(),hijri?.year.toString())
        tv_Imsak.text = time?.imsak
        tv_Fajr.text = time?.fajr
        tv_Dhuhr.text = time?.dhuhr
        tv_Asr.text = time?.asr
        tv_Maghrib.text = time?.maghrib
        tv_Isha.text = time?.isha
        tv_jam_menit.text = time!!.imsak
        tv_timedesc.text = "Imsyak"
    }

    override fun onCalendarCompleteFromApi(calendar: Calendar) {
        /*tv_informasi.text = calendar.data?.get(0)?.date?.readable.toString()*/
        d("Mainact","Calendar data: ${calendar.data?.size}")
    }


    override fun onTimingsErrorFromApi(throwable: Throwable) {

        Toast.makeText(this,"Error ${throwable.localizedMessage}", Toast.LENGTH_LONG).show()
    }

    override fun onCalendarErrorFromApi(throwable: Throwable) {

        Toast.makeText(this,"Error ${throwable.localizedMessage}", Toast.LENGTH_LONG).show()
    }

    private fun hijriTextFormat(day: String, month: String, year: String): String{
        return "$day $month $year"
    }



}
