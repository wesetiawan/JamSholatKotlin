package com.ws.jamsholat.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ws.jamsholat.R
import com.ws.jamsholat.model.Data
import com.ws.jamsholat.model.Timings
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IMainView{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainPresenter(this).getDataFromApi()

    }

    override fun onDataCompleteFromApi(data: Data) {
        val time = data.timings
        val date = data.date
        tv_time.text = date?.readable
        tv_hijri.text = date?.hijri?.date
        tv_Imsak.text = time?.imsak.toString()
        tv_Fajr.text = time?.fajr.toString()
        tv_Dhuhr.text = time?.dhuhr.toString()
        tv_Asr.text = time?.asr.toString()
        tv_Maghrib.text = time?.maghrib.toString()
        tv_Isha.text = time?.isha.toString()
    }


    override fun onDataErrorFromApi(throwable: Throwable) {
        error("error ------------> ${throwable.localizedMessage}")
        Toast.makeText(this,"Error ${throwable.localizedMessage.toString()}", Toast.LENGTH_SHORT).show()
    }


}
