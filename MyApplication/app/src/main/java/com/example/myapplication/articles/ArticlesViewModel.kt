package com.example.myapplication.articles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.models.Articles
import com.example.myapplication.data.repositories.ArticlesRepository
import com.example.myapplication.util.Coroutines
import kotlinx.coroutines.Job

class ArticlesViewModel(
    private val repository: ArticlesRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _articles = MutableLiveData<List<Articles>>()
    val movies: LiveData<List<Articles>>
        get() = _articles

    fun getMovies() {
        job = Coroutines.ioThenMain(
            { repository.getArticles() },
            { _articles.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}