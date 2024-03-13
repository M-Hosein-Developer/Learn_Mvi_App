package com.example.mvilearn1.ui.state

import com.example.mvilearn1.model.repository.User
import java.lang.Error

sealed class MainState {

    object Idle : MainState()
    object Loading : MainState()
    data class Users(val user: List<User>) : MainState()
    data class Error(val error: String?) : MainState()

}