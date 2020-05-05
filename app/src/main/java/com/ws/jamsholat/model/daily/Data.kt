package com.ws.jamsholat.model.daily

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(

    @field:SerializedName("date")
	val date: Date? = null,

    @field:SerializedName("timings")
	val timings: Timings? = null
) : Parcelable