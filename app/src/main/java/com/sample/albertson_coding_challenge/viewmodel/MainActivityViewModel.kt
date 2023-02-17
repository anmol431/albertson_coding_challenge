package com.sample.albertson_coding_challenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.albertson_coding_challenge.model.AcromineData
import com.sample.albertson_coding_challenge.repository.MainActivityRepository

class MainActivityViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<AcromineData>? = null

    fun getUser() : LiveData<AcromineData>? {
        servicesLiveData = MainActivityRepository.getServicesApiCall()
        return servicesLiveData
    }

}