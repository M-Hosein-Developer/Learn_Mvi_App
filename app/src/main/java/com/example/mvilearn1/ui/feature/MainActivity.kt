package com.example.mvilearn1.ui.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvilearn1.ui.theme.MviLearn1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MviLearn1Theme {

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MviLearn1Theme {

    }
}