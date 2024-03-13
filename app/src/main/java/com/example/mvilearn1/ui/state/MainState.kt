package com.example.mvilearn1.ui.state

import com.example.mvilearn1.model.model.User

sealed class MainState {

    object Idle : MainState()
    object Loading : MainState()
    data class Users(val user: List<User.UserItem>) : MainState()
    data class Error(val error: String?) : MainState()

}