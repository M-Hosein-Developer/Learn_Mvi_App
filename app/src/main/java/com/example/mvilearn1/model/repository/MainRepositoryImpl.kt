package com.example.mvilearn1.model.repository

import com.example.mvilearn1.model.api.ApiHelper
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val apiHelper: ApiHelper) : MainRepository{

    override suspend fun getUser() = apiHelper.getUser()

}