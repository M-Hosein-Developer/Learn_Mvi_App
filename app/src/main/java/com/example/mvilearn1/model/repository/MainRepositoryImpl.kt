package com.example.mvilearn1.model.repository

import com.example.mvilearn1.model.api.ApiHelper

class MainRepositoryImpl(private val apiHelper: ApiHelper) : MainRepository{

    override suspend fun getUser() = apiHelper.getUser()

}