package com.ws.jamsholat.activity.main

import com.ws.jamsholat.model.daily.Data
import com.ws.jamsholat.model.calendar.Calendar

interface IMainView{
    fun onTimingsCompleteFromApi(data: Data)
    fun onCalendarCompleteFromApi(calendar: Calendar)
    fun onTimingsErrorFromApi(throwable: Throwable)
    fun onCalendarErrorFromApi(throwable: Throwable)
}