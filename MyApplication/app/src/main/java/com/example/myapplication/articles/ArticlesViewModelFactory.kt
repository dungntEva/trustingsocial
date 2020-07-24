package com.example.myapplication.articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.repositories.ArticlesRepository

@Suppress("UNCHECKED_CAST")
class ArticlesViewModelFactory(
    private val repository: ArticlesRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArticlesViewModel(repository) as T
    }

}