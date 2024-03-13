package com.example.mvilearn1.model.api

import com.example.mvilearn1.model.repository.User
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUser(): List<User> {
        return apiService.getUser()
    }

}