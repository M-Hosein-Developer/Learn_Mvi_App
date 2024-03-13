package com.example.mvilearn1.model.api

import com.example.mvilearn1.model.repository.User

interface ApiHelper {

    suspend fun getUser() : List<User>

}