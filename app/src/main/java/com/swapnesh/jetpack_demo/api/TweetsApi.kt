package com.swapnesh.jetpack_demo.api

import com.swapnesh.jetpack_demo.models.TweetsListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsApi {
    @GET("b/6829d80a8561e97a50168617?meta=false")
    suspend  fun getTweets(@Header("X-JSON-Path") category:String):Response<List<TweetsListItem>>


    @GET("b/6829d80a8561e97a50168617?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategory(): Response<List<String>>
}