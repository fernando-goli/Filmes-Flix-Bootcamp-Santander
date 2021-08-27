package com.fgomes.filmes_flix_bootcamp_santander.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.fgomes.filmes_flix_bootcamp_santander.R
import com.fgomes.filmes_flix_bootcamp_santander.model.Movie
import com.fgomes.filmes_flix_bootcamp_santander.viewmodel.MovieListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var movieListViewModel: MovieListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieListViewModel = ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieListViewModel.init()
        initObserver()
        loadVisibility(true)
    }

    private fun initObserver(){
        movieListViewModel.moviesList.observe(this, { list ->
            if (list.isNotEmpty()){
                populateList(list)
                loadVisibility(false)
            }
        })
    }

    private fun populateList(list: List<Movie>) {
        val moviesList = findViewById<RecyclerView>(R.id.moviesList)
        moviesList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(list)
        }
    }

    private fun loadVisibility(isLoading: Boolean){
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = if( isLoading) View.VISIBLE else View.GONE
    }

}