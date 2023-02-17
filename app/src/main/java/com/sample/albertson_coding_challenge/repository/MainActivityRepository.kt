package com.sample.albertson_coding_challenge.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sample.albertson_coding_challenge.model.AcromineData
import com.sample.albertson_coding_challenge.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    val serviceSetterGetter = MutableLiveData<AcromineData>()

    fun getServicesApiCall(): MutableLiveData<AcromineData> {

        val call = RetrofitClient.apiInterface.getServices("SS")

        call.enqueue(object : Callback<AcromineData> {
            override fun onFailure(call: Call<AcromineData>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<AcromineData>,
                response: Response<AcromineData>
            ) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

                serviceSetterGetter.value = data!!
            }
        })

        return serviceSetterGetter
    }
}