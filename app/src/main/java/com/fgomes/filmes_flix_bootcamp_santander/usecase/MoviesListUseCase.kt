package com.fgomes.filmes_flix_bootcamp_santander.usecase

import com.fgomes.filmes_flix_bootcamp_santander.data.MovieRepository


class MoviesListUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke() = movieRepository.getAllMoviesFromDataSource()


}