package com.fgomes.filmes_flix_bootcamp_santander.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRestApiTask {

    //https://raw.githubusercontent.com/
    companion object{
        const val BASE_URL = "https://raw.githubusercontent.com/"
    }

    private fun movieProvider(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofitApi(): MovieApi = movieProvider().create(MovieApi::class.java)

}