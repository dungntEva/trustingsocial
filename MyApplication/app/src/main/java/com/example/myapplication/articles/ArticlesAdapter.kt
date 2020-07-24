package com.example.myapplication.articles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.models.Articles
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.RecycleviewArticlesBinding

class ArticlesAdapter (
    private val articles: List<Articles>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>(){

    override fun getItemCount() = articles.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ArticlesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recycleview_articles,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        holder.recyclerviewArticlesBinding.articles = articles[position]
        holder.recyclerviewArticlesBinding.buttonBook.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerviewArticlesBinding.buttonBook, articles[position])
        }
        holder.recyclerviewArticlesBinding.layoutLike.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerviewArticlesBinding.layoutLike, articles[position])
        }
    }


    inner class ArticlesViewHolder(
        val recyclerviewArticlesBinding: RecycleviewArticlesBinding
    ) : RecyclerView.ViewHolder(recyclerviewArticlesBinding.root)

}