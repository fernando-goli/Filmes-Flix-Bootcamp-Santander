package com.fgomes.filmes_flix_bootcamp_santander.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }

    private fun initObserver(){
        movieListViewModel.movieList.observe(this, { list ->
            populateList(list)
        })
    }

    private fun populateList(list: List<Movie>) {
        var moviesList = findViewById<RecyclerView>(R.id.moviesList)
        moviesList.apply {

            hasFixedSize()
            adapter = MoviesAdapter(list)

        }
    }

}