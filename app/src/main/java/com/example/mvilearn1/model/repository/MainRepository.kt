package com.example.mvilearn1.model.repository

import com.example.mvilearn1.model.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUser() = apiHelper.getUser()

}