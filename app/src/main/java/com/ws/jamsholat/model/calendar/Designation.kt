package com.ws.jamsholat.model.calendar

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Designation(

	@field:SerializedName("expanded")
	val expanded: String? = null,

	@field:SerializedName("abbreviated")
	val abbreviated: String? = null
) : Parcelable