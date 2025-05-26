package com.swapnesh.jetpack_demo.viewmodules



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.swapnesh.jetpack_demo.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainviewModule @Inject constructor(private val tweetRepository: TweetRepository
) : ViewModel()  {

    val categories : StateFlow<List<String>>
        get() = tweetRepository.categroies


    init {
        viewModelScope.launch {
            tweetRepository.getCategory()
        }
    }


}