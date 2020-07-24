package com.example.myapplication.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.data.models.Articles
import com.example.myapplication.data.network.ArticlesApi
import com.example.myapplication.data.repositories.ArticlesRepository
import com.example.myapplication.viewmodels.ArticlesExamViewModel
import kotlinx.android.synthetic.main.articles_fragment.*

class ArticlesFragment : BaseFragment(), RecyclerViewClickListener{

    private lateinit var factory: ArticlesViewModelFactory
    private lateinit var viewModel: ArticlesViewModel


    private var articlesViewModel: ArticlesExamViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.articles_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        val api = ArticlesApi()
//        val repository = ArticlesRepository(api)
//
//        factory = ArticlesViewModelFactory(repository)
//        viewModel = ViewModelProviders.of(this, factory).get(ArticlesViewModel::class.java)
//
//        viewModel.getMovies()
//
//        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
//            recycler_view_articles.also {
//                it.layoutManager = LinearLayoutManager(requireContext())
//                it.setHasFixedSize(true)
//                it.adapter = ArticlesAdapter(movies, this)
//            }
//        })


        setupViewModels()
    }

    override fun onRecyclerViewItemClick(view: View, movie: Articles) {
        when(view.id){
            R.id.button_book -> {
                Toast.makeText(requireContext(), "Book Button Clicked", Toast.LENGTH_LONG).show()
            }
            R.id.layout_like ->{
                Toast.makeText(requireContext(), "Like Layout Clicked", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setupViewModels() {

        articlesViewModel = getViewModel(ArticlesExamViewModel::class.java)
        articlesViewModel?.getArticles()

        articlesViewModel?.listArticles?.observe(viewLifecycleOwner, Observer {list ->

            list?.let {

                recycler_view_articles.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = ArticlesAdapter(list, this)
            }

            }



        })

    }
}