package com.example.final_evaluation.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.final_evaluation.model.Photos
import com.example.final_evaluation.retrofit.ApiInterface
import com.example.final_evaluation.retrofit.RetrofitClient
import com.example.final_evaluation.room.PhotoDatabase
import com.example.final_evaluation.utils.NetworkUtils
import kotlinx.coroutines.*

class HomeActivityRepository(
    private val photoDatabase: PhotoDatabase,
    private val applicationContext: Context
) {
    private var photoLiveData = MutableLiveData<List<Photos>>()
    val errorMessage = MutableLiveData<String>()
    var job: Job? = null
    var job2: Job? = null

    val exceptionHandler = CoroutineExceptionHandler { _,
                                                       throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }


    fun getServicesAPICall(): MutableLiveData<List<Photos>> {
        if (NetworkUtils.isInternetAvailable(applicationContext)) {
            job = CoroutineScope(
                Dispatchers.IO +
                        exceptionHandler
            ).launch {
                val response = RetrofitClient.getInstance().create(ApiInterface::class.java)
                val res = response.getServicesAPICall()
                withContext(Dispatchers.Main) {


                    if (res.isSuccessful) {

                        photoDatabase.photoDao().insertMemes(res.body()!!)
                        photoLiveData.postValue(res.body())

                    } else {
                        onError("Error : ${res.message()}")
                    }

                }
            }

        } else {
            job2 = CoroutineScope(Dispatchers.IO).launch {
                withContext(Dispatchers.IO) {
                    val photos = photoDatabase.photoDao().getPhotos()
                    photoLiveData.postValue(photos)

                }
            }


        }
        return photoLiveData
    }

    private fun onError(message: String) {
        errorMessage.postValue(message)
    }


}