package com.fgomes.filmes_flix_bootcamp_santander.framework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fgomes.filmes_flix_bootcamp_santander.framework.api.MovieRestApiTask
import com.fgomes.filmes_flix_bootcamp_santander.data.MovieRepository
import com.fgomes.filmes_flix_bootcamp_santander.domain.Movie
import com.fgomes.filmes_flix_bootcamp_santander.implementations.MovieDataSourceImplementations
import com.fgomes.filmes_flix_bootcamp_santander.usecase.MoviesListUseCase
import java.lang.Exception

class MoviesListViewModel:ViewModel() {

    companion object {
        const val TAG = "MovieRepository"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSource = MovieDataSourceImplementations(movieRestApiTask)
    private val movieRepository = MovieRepository (movieDataSource)
    private val moviesListUseCase = MoviesListUseCase(movieRepository)

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
    get() = _moviesList

    fun init(){
        getAllMovies()
    }

    private fun getAllMovies(){
        Thread{
            try {
                _moviesList.postValue(moviesListUseCase.invoke())
            } catch (exception: Exception){
                Log.d(TAG, exception.message.toString())
            }
        }.start()

    }
}