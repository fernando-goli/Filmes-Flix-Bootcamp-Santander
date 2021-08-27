package com.fgomes.filmes_flix_bootcamp_santander.implementations

import android.util.Log
import com.fgomes.filmes_flix_bootcamp_santander.framework.api.MovieRestApiTask
import com.fgomes.filmes_flix_bootcamp_santander.data.MovieDataSource
import com.fgomes.filmes_flix_bootcamp_santander.domain.Movie

class MovieDataSourceImplementations(private val  movieRestApiTask: MovieRestApiTask): MovieDataSource {

    companion object {
        const val TAG = "MovieRepository"
    }

    private val movieList = arrayListOf<Movie>()

    override fun getAllMovies(): List<Movie> {
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