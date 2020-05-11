package com.ws.jamsholat.activity.ui.scrolldatepick.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.ws.jamsholat.model.daily.Hijri
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