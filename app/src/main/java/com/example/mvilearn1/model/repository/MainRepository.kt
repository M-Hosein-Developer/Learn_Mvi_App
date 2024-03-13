package com.example.mvilearn1.model.repository

interface MainRepository {

    suspend fun getUser() : List<User>

}