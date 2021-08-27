package com.fgomes.filmes_flix_bootcamp_santander.repository

import android.util.Log
import com.fgomes.filmes_flix_bootcamp_santander.api.MovieRestApiTask
import com.fgomes.filmes_flix_bootcamp_santander.model.Movie

class MovieRepository(private val movieRestApiTask: MovieRestApiTask) {

    companion object {
        const val TAG = "MovieRepository"
    }

    private val movieList = arrayListOf<Movie>()

    fun getAllMovies(): List<Movie>{

        val request = movieRestApiTask.retrofitApi().getAllMovies().execute()

        if (request.isSuccessful){
            request.body()?.let {
                movieList.addAll(it)
            }
        } else {
            request.errorBody().let {
                Log.d(TAG, it.toString())
            }

        }

        return movieList
    }

}