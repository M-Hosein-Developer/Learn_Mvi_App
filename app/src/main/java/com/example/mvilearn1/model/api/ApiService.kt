package com.example.mvilearn1.model.api

import com.example.mvilearn1.model.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUser() : List<User.UserItem>

}