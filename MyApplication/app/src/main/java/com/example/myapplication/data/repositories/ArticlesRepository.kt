package com.example.myapplication.data.repositories

import com.example.myapplication.data.network.ArticlesApi

class ArticlesRepository(
    private val api: ArticlesApi
) : SafeApiRequest() {

    suspend fun getArticles() = apiRequest { api.getArticles() }

}