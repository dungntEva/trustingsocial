package com.example.myapplication.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.base.BaseViewModel
import com.example.myapplication.data.models.Article
import com.example.myapplication.data.models.Articles
import com.example.myapplication.network.response.ApiRepository
import com.example.myapplication.network.service.ApiClient
import kotlinx.coroutines.launch

class ArticlesExamViewModel(private val repository: ApiRepository = ApiRepository(ApiClient.apiService)) : BaseViewModel() {

    val listArticles = MutableLiveData<List<Articles>>()

    /**
     * get data
     */
    fun getArticles() {

        ioScope.launch {

            val response = repository.getArticles()

            if (response.articles != null) {
                listArticles.postValue(response.articles)

            } else {
                // error
            }

        }
    }
}