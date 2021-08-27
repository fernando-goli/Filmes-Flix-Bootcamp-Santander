package com.fgomes.filmes_flix_bootcamp_santander.data

import com.fgomes.filmes_flix_bootcamp_santander.domain.Movie

interface MovieDataSource {

    fun getAllMovies(): List<Movie>
}