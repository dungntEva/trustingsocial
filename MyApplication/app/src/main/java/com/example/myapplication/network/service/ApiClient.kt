package com.example.myapplication.network.service

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    // API Param
    private const val AUTHORIZATION_HEADER = "Authorization"
    private const val LANGUAGE_HEADER = "Accept-Language"
    private const val TOKEN_TYPE = "bearer"
    private const val TIME_OUT = 300L // In second
    private const val CONTENT_TYPE = "Content-Type"

    private fun getBaseUrl() = "https://moneyforwardvietnam.github.io"

    private fun getClient(url: String): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
        return getRetrofit(url, okHttpClient)
    }

    private fun getRetrofit(url: String, builder: OkHttpClient.Builder): Retrofit {

        builder.apply {

            connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            readTimeout(TIME_OUT, TimeUnit.SECONDS)
            writeTimeout(TIME_OUT, TimeUnit.SECONDS)
        }

        val moshi = Moshi.Builder()
            .build()

        return Retrofit.Builder().apply {
            baseUrl(url)
            addCallAdapterFactory(CoroutineCallAdapterFactory())
            addConverterFactory(MoshiConverterFactory.create(moshi))
            client(builder.build())
        }.build()
    }

    val apiService = getClient(getBaseUrl()).create(ApiService::class.java)
}