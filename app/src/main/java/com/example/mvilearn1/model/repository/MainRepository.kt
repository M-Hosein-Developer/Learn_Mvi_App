package com.example.mvilearn1.model.repository

import com.example.mvilearn1.model.model.User

interface MainRepository {

    suspend fun getUser() : List<User.UserItem>

}