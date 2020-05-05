package com.ws.jamsholat.model.calendar

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataItem(

	@field:SerializedName("date")
	val date: Date? = null,

	@field:SerializedName("meta")
	val meta: Meta? = null,

	@field:SerializedName("timings")
	val timings: Timings? = null
) : Parcelable