package com.ws.jamsholat.model.calendar

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Offset(

	@field:SerializedName("Sunset")
	val sunset: Int? = null,

	@field:SerializedName("Asr")
	val asr: Int? = null,

	@field:SerializedName("Isha")
	val isha: Int? = null,

	@field:SerializedName("Fajr")
	val fajr: Int? = null,

	@field:SerializedName("Dhuhr")
	val dhuhr: Int? = null,

	@field:SerializedName("Maghrib")
	val maghrib: Int? = null,

	@field:SerializedName("Sunrise")
	val sunrise: Int? = null,

	@field:SerializedName("Midnight")
	val midnight: Int? = null,

	@field:SerializedName("Imsak")
	val imsak: Int? = null
) : Parcelable