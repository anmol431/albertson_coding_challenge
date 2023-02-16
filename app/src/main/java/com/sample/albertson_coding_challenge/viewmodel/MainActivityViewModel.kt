package com.sample.albertson_coding_challenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.albertson_coding_challenge.model.ServicesSetterGetter
import com.sample.albertson_coding_challenge.repository.MainActivityRepository

class MainActivityViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<ServicesSetterGetter>? = null

    fun getUser() : LiveData<ServicesSetterGetter>? {
        servicesLiveData = MainActivityRepository.getServicesApiCall()
        return servicesLiveData
    }

}