package com.example.mvilearn1.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvilearn1.model.repository.MainRepository
import com.example.mvilearn1.ui.intent.MainIntent
import com.example.mvilearn1.ui.state.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {


    val userIntent = Channel<MainIntent>(Channel.UNLIMITED)
    private val _state = MutableStateFlow<MainState>(MainState.Idle)

    val state : StateFlow<MainState> get() = _state

    init {
        handleIntent()
    }

    private fun handleIntent() {

        viewModelScope.launch {

            userIntent.consumeAsFlow().collect{

                when (it){
                    is MainIntent.FetchUser -> fetchUser()
                }

            }

        }

    }

    private fun fetchUser() {

        viewModelScope.launch {

            _state.value = MainState.Loading
            _state.value = try {

                MainState.Users(repository.getUser())

            }catch (e : Exception){

                MainState.Error(e.localizedMessage)

            }

        }

    }

}