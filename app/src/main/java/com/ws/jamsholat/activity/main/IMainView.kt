package com.ws.jamsholat.activity.main

import com.ws.jamsholat.activity.ui.scrolldatepick.model.DatePickerModel
import com.ws.jamsholat.model.daily.Data

interface IMainView{
    fun onLoadDataFromAPi()
    fun onTimingsCompleteFromApi(data: Data)
    fun onTimingsErrorFromApi(throwable: Throwable)
    fun onCalendarCompleteFromApi(dataItem: List<DatePickerModel>)
    fun onCalendarErrorFromApi(throwable: Throwable)
}