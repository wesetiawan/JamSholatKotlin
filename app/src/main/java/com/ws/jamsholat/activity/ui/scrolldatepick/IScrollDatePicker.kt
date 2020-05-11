package com.ws.jamsholat.activity.ui.scrolldatepick

import com.ws.jamsholat.activity.ui.scrolldatepick.model.DatePickerModel

interface IScrollDatePicker{
    fun setData(data: List<DatePickerModel>)
    fun show()
}