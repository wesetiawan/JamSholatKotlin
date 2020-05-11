package com.ws.jamsholat.util

import java.text.SimpleDateFormat
import java.util.*

val date: Date = Calendar.getInstance().time

fun getCurrentTimeMillis(): Long {
    return System.currentTimeMillis()
}

fun getCurrentDate(): Date {
    return Calendar.getInstance().time
}

fun getCurrentDay():Int{
    val formatter = SimpleDateFormat("dd", Locale.ROOT)
    return formatter.format(date).toInt()
}


fun getCurrentMonth():Int{
    val formatter = SimpleDateFormat("MM", Locale.ROOT)
    return formatter.format(date).toInt()
}

fun getCurrentYear():Int{
    val formatter = SimpleDateFormat("YYYY", Locale.ROOT)
    return formatter.format(date).toInt()
}


fun Date.toInt(format: String, locale: Locale = Locale.getDefault()): Int {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this).toInt()

}
