package com.sample.albertson_coding_challenge.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sample.albertson_coding_challenge.model.AcromineData
import com.sample.albertson_coding_challenge.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    val serviceSetterGetter = MutableLiveData<ArrayList<AcromineData>>()

    fun getServicesApiCall(param: String): MutableLiveData<ArrayList<AcromineData>> {

        val call = RetrofitClient.apiInterface.getServices(param)

        call.enqueue(object : Callback<ArrayList<AcromineData>> {
            override fun onFailure(call: Call<ArrayList<AcromineData>>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<ArrayList<AcromineData>>,
                response: Response<ArrayList<AcromineData>>
            ) {
                val data = response.body()

                serviceSetterGetter.value = data!!
            }
        })

        return serviceSetterGetter
    }
}