package com.ws.jamsholat.model.daily

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hijri(

    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("format")
    val format: String? = null,

    @field:SerializedName("day")
    val day: String? = null,

    @field:SerializedName("month")
    val month: Month? = null,

    @field:SerializedName("year")
    val year: String? = null

) : Parcelable