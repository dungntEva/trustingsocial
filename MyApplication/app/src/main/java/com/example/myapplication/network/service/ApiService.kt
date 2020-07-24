package com.example.myapplication.network.service

import com.example.myapplication.data.models.Articles
import com.example.myapplication.network.response.ApiResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("/1/1")
    fun getArticlesAsync(): Deferred<Response<ApiResponse<List<Articles>>>>

}
