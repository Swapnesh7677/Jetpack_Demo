package com.swapnesh.jetpack_demo.sreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.swapnesh.jetpack_demo.viewmodules.TweetsViewModule


@Composable
fun DetailScreen() {
    
    val tweetsViewModule :TweetsViewModule = hiltViewModel()
    val tweets  = tweetsViewModule.tweets.collectAsState()

    LazyColumn(modifier = Modifier.padding(top = 25.dp),
        content = {
        items(tweets.value){
            TweetsList(tweet = it.tweet)
        }
    }) 
    
}


@Composable
fun TweetsList(tweet:String){
    
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC)),
        content = {
            Text(
                text = tweet,
                modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.
                bodyLarge
            )
        }
    ) 
}


