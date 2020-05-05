package com.ws.jamsholat.model.daily
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Month(

    @field:SerializedName("number")
    val number: String? = null,

    @field:SerializedName("en")
    val en: String? = null,

    @field:SerializedName("ar")
    val ar: String? = null
) : Parcelable