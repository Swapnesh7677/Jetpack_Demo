package com.swapnesh.jetpack_demo.viewmodules

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swapnesh.jetpack_demo.models.TweetsListItem
import com.swapnesh.jetpack_demo.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TweetsViewModule @Inject constructor(private val tweetRepository: TweetRepository,
    private val savedStateHandle: SavedStateHandle) : ViewModel() {


    val tweets: StateFlow<List<TweetsListItem>>
        get() = tweetRepository.tweets

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category") ?: "Android"
            tweetRepository.getTweets(category)
        }
    }
}