package com.ws.jamsholat.util

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*


class Util {

    companion object{
        fun getCurrentTimeMillis(): Long {
            return System.currentTimeMillis()
        }

        fun getCurrentDate(): Date {
            return Calendar.getInstance().time
        }


        fun getCurrentLatitude(): String {
            return "-7.795580"
        }

        fun getCurrentLongitude(): String {
            return "110.369492"
        }

        fun Date.toInt(format: String, locale: Locale = Locale.getDefault()): Int {
            val formatter = SimpleDateFormat(format, locale)
            return formatter.format(this).toInt()


        }
    }


}
