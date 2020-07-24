package com.example.myapplication.network.response

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class ApiResponse<T>(

    @Json(name = "status")
    val status: Boolean? = null,

    @Json(name = "1")
    val articles: T?  = null,

    @Json(name = "errorCode")
    val errorCode: Int? = null,

    @Json(name = "errorMessage")
    val errorMessage: String? = null

)
