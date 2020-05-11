package com.ws.jamsholat.activity.ui.scrolldatepick.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Calendar(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: List<DatePickerModel?>? = null,

	@field:SerializedName("status")
	val status: String? = null
) : Parcelable