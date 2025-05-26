package com.swapnesh.jetpack_demo.repository

import com.swapnesh.jetpack_demo.api.TweetsApi
import com.swapnesh.jetpack_demo.models.TweetsListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private var tweetsApi: TweetsApi) {

    private  val _category = MutableStateFlow<List<String>>(emptyList())
    val categroies : StateFlow<List<String>>
        get() = _category

    private val _tweets = MutableStateFlow<List<TweetsListItem>>(emptyList())
    val tweets : StateFlow<List<TweetsListItem>>
        get() = _tweets



    suspend fun getCategory(){
        val response = tweetsApi.getCategory()
        if (response.isSuccessful && response.body()!= null){
            _category.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category:String){
        val responseTweets  = tweetsApi.getTweets("tweets[?(@.category==\"$category\")]")
        if (responseTweets.isSuccessful && responseTweets.body() != null){
            _tweets.emit(responseTweets.body()!!)
        }
    }
}