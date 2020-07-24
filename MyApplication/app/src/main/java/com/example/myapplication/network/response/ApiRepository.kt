package com.example.myapplication.network.response

import com.example.myapplication.data.models.Articles
import com.example.myapplication.network.service.ApiService

class ApiRepository(private val apiService: ApiService) : BaseRepository() {

    // getArticles
    suspend fun getArticles(): ApiResponse<List<Articles>> = makeApiCall {
        apiService.getArticlesAsync().await()
    }

}