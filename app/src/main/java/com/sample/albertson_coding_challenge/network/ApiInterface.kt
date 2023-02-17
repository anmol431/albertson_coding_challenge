package com.sample.albertson_coding_challenge.network

import com.sample.albertson_coding_challenge.model.AcromineData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("dictionary.py")
    fun getServices(@Query("sf") sf: String): Call<ArrayList<AcromineData>>

}