package com.example.mvilearn1.ui.feature

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.lifecycleScope
import com.example.mvilearn1.model.model.User
import com.example.mvilearn1.ui.state.MainState
import com.example.mvilearn1.ui.theme.MviLearn1Theme
import com.example.mvilearn1.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val user = mutableStateOf(listOf<User.UserItem>())

        Log.v("testData" , user.value.toString())
        lifecycleScope.launch() {

            viewModel.state.collect {

                when (it) {

                    is MainState.Idle -> {
                        Toast.makeText(this@MainActivity, "Idle...", Toast.LENGTH_SHORT).show()
                    }

                    is MainState.Loading -> {
                        Toast.makeText(this@MainActivity, "loading...", Toast.LENGTH_LONG).show()
                    }

                    is MainState.Users -> {
                        user.value = it.user
                        Log.v("testData1" , it.user.toString())
                        Toast.makeText(this@MainActivity, "$user", Toast.LENGTH_SHORT).show()
                    }

                    is MainState.Error -> {
                        Toast.makeText(this@MainActivity, "$it", Toast.LENGTH_SHORT).show()
                    }

                }

                Log.v("testData2" , user.value.toString())

            }

        }

        Log.v("testData3" , user.value.toString())


        setContent {
            MviLearn1Theme {

                Log.v("testData4" , user.value.toString())

                HomeScreen(viewModel, user.value)

            }
        }
    }
}
