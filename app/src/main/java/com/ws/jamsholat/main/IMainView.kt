package com.ws.jamsholat.main

import com.ws.jamsholat.model.Data

interface IMainView{
    fun onDataCompleteFromApi(data : Data)
    fun onDataErrorFromApi(throwable: Throwable)
}