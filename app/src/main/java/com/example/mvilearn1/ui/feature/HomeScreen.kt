package com.example.mvilearn1.ui.feature

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvilearn1.model.model.User
import com.example.mvilearn1.ui.intent.MainIntent
import com.example.mvilearn1.viewModel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun HomeScreen(viewModel: MainViewModel, user: List<User.UserItem>) {

    GlobalScope.launch(Dispatchers.IO) {
        viewModel.userIntent.send(MainIntent.FetchUser)
    }

    Column(
        Modifier.fillMaxSize()
    ) {


        UserLazyColumn(user)

    }

}

@Composable
fun UserLazyColumn(user: List<User.UserItem>) {

    LazyColumn {

        items(user.size) {
            UserLazyColumnItem(user[it])
        }

    }

}

@Composable
fun UserLazyColumnItem(user: User.UserItem) {

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(16.dp)
    ) {

        Text(text = "id: " + user.id, color = Color.Black)

        Text(
            text = "name: " + user.name, color = Color.Black ,
            style = TextStyle(fontWeight = FontWeight.Bold , fontSize = 18.sp)
        )

        Text(
            text = "email: " + user.email, color = Color.Black,
            style = TextStyle(fontSize = 18.sp)
        )

    }


}