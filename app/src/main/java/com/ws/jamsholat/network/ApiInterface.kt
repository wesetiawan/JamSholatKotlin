package com.ws.jamsholat.network

import com.ws.jamsholat.model.daily.ShalatData
import com.ws.jamsholat.model.calendar.Calendar
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("timings")
    fun getTodayApi(
        @Query("timestamp") timestamp: Long,
        @Query("latitude") latitude: String,
        @Query("longitude") longitude: String,
        @Query("method") method: String
    ): Call<ShalatData>

    @GET("calendar")
    fun getHijCalendar(
        @Query("latitude") latitude: String,
        @Query("longitude") longitude: String,
        @Query("method") method: String,
        @Query("month") month: Int,
        @Query("year") year: Int
    ): Call<Calendar>

    companion object {
        fun createDaily(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.aladhan.com/v1/")
                .build()
            return retrofit.create(ApiInterface::class.java)
        }

        fun createHijCalendar(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.aladhan.com/v1/")
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}