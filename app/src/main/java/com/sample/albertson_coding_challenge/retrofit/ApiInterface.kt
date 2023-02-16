package com.sample.albertson_coding_challenge.retrofit

import com.sample.albertson_coding_challenge.model.ServicesSetterGetter
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("services")
    fun getServices(): Call<ServicesSetterGetter>

}