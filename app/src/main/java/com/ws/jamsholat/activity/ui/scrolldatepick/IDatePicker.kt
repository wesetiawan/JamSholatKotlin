package com.ws.jamsholat.activity.ui.scrolldatepick

import com.ws.jamsholat.model.calendar.DataItem

interface IDatePicker{
    fun onLoadDate(item: DataItem, position: Int)
    fun onDateClick(item: DataItem,position: Int)
}