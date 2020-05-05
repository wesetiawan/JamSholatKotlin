package com.ws.jamsholat.model.calendar

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Gregorian(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("month")
	val month: Month? = null,

	@field:SerializedName("year")
	val year: String? = null,

	@field:SerializedName("format")
	val format: String? = null,

	@field:SerializedName("weekday")
	val weekday: Weekday? = null,

	@field:SerializedName("designation")
	val designation: Designation? = null,

	@field:SerializedName("day")
	val day: String? = null
) : Parcelable