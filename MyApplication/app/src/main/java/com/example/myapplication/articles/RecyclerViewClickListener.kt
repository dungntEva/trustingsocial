package com.example.myapplication.articles

import android.view.View
import com.example.myapplication.data.models.Articles

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, articles: Articles)
}