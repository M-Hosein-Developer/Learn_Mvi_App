package com.example.mvilearn1.model.api

import com.example.mvilearn1.model.model.User

interface ApiHelper {

    suspend fun getUser() : List<User.UserItem>

}