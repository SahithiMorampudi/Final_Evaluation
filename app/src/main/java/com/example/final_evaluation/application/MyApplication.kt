package com.example.final_evaluation.application

import android.app.Application
import com.example.final_evaluation.repository.HomeActivityRepository
import com.example.final_evaluation.room.PhotoDatabase

class MyApplication : Application() {

    lateinit var homeActivityRepository: HomeActivityRepository

    override fun onCreate() {
        super.onCreate()

        val database = PhotoDatabase.getDataBase(applicationContext)
        homeActivityRepository = HomeActivityRepository(database, applicationContext)
    }
}