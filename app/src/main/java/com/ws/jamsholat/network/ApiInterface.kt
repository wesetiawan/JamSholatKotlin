package com.ws.jamsholat.network

import com.ws.jamsholat.model.ShalatData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface{
    @GET("timings")
    fun getApi(@Query("timestamp") timestamp: Long,
               @Query("latitude") latitude: String,
               @Query("longitude")longitude: String,
               @Query("method") method:String): Call<ShalatData>

    companion object{
        fun create(): ApiInterface{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.aladhan.com/v1/timings/")
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}