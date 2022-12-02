package com.example.final_evaluation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.final_evaluation.model.Photos
import com.example.final_evaluation.repository.HomeActivityRepository

class HomeViewModel : ViewModel() {

    var photoLiveData: MutableLiveData<List<Photos>>? = null

    private var homeRepository: HomeActivityRepository? = null
    private val photoList = ArrayList<Photos>()
    fun setHomeRepository(homeRepository: HomeActivityRepository) {
        this.homeRepository = homeRepository
    }

    fun getServicesAPICall(): MutableLiveData<List<Photos>>? {
        photoLiveData = homeRepository?.getServicesAPICall()
        return photoLiveData
    }


}