package com.ws.jamsholat.model.daily

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Date(

    @field:SerializedName("readable")
	val readable: String? = null,

    @field:SerializedName("hijri")
	val hijri: Hijri? = null,

    @field:SerializedName("timestamp")
	val timestamp: String? = null
) : Parcelable