package com.example.myapplication.network.response

import retrofit2.Response

open class BaseRepository {

    suspend fun <T : Any> makeApiCall(call: suspend () -> Response<ApiResponse<T>>): ApiResponse<T> {

        return try {
            val response = call.invoke()

            if (response.isSuccessful) {
                response.body()?.let {
                    it
                } ?: run {
                    ApiResponse<T>(status = true, articles = null)
                }
            } else {
                handleError(response)
            }

        } catch (ex: Exception) {

            //var error = AppResource.getString(R.string.error_server)
            val error = ex.message

            ApiResponse(
                status = false,
                errorCode = null,
                errorMessage = error,
                articles = null
            )
        }
    }

    private fun <T : Any> handleError(response: Response<ApiResponse<T>>?): ApiResponse<T> {

        response?.errorBody()?.let {
            try {
                // parser error body
                val jsonError = it.string()
                return ApiResponse(
                    status = false,
                    errorMessage = jsonError,
                    articles = null
                )

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


        return ApiResponse(
            status = false,
            errorMessage = "Error",
            articles = null
        )
    }
}
