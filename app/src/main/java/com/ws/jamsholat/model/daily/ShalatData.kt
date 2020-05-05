package com.ws.jamsholat.model.daily

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.ws.jamsholat.model.daily.Data
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShalatData(

    @field:SerializedName("code")
	val code: Int? = null,

    @field:SerializedName("data")
	val data: Data? = null,

    @field:SerializedName("status")
	val status: String? = null
) : Parcelable