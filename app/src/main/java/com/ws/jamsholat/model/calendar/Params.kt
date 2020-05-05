package com.ws.jamsholat.model.calendar

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Params(

	@field:SerializedName("Isha")
	val isha: Double? = null,

	@field:SerializedName("Fajr")
	val fajr: Double? = null
) : Parcelable