package com.example.myapplication.data.network

import com.example.myapplication.data.models.Articles
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ArticlesApi {

    @GET("articles")
    suspend fun getArticles() : Response<List<Articles>>

    companion object{
        operator fun invoke() : ArticlesApi {

            return Retrofit.Builder()
                .baseUrl("https://moneyforwardvietnam.github.io/example-feed/feed.json")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ArticlesApi::class.java)

        }
    }
}