package com.ws.jamsholat.model.calendar

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weekday(

	@field:SerializedName("en")
	val en: String? = null,

	@field:SerializedName("ar")
	val ar: String? = null
) : Parcelable