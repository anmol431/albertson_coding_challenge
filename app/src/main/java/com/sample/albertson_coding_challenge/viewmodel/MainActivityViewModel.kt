package com.sample.albertson_coding_challenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.albertson_coding_challenge.model.AcromineData
import com.sample.albertson_coding_challenge.repository.MainActivityRepository

class MainActivityViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<ArrayList<AcromineData>>? = null

    fun getUser(param : String) : LiveData<ArrayList<AcromineData>>? {
        servicesLiveData = MainActivityRepository.getServicesApiCall(param)
        return servicesLiveData
    }

}