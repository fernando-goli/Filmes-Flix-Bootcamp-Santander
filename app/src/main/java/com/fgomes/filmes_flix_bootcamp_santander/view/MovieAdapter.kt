package com.fgomes.filmes_flix_bootcamp_santander.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.fgomes.filmes_flix_bootcamp_santander.R
//import kotlinx.android.synthetic.main.movie_item_layout.view.*
import com.fgomes.filmes_flix_bootcamp_santander.model.Movie

class MoviesAdapter(private val moviesList: List<Movie>): RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        //holder.itemView.movieTitle
        holder.itemView.apply {
            findViewById<TextView>(R.id.movieTitle).text = moviesList[position].titulo
            findViewById<ImageView>(R.id.movieImage).load(moviesList[position].imagem){
                placeholder(R.drawable.ic_photo)
                fallback(R.drawable.ic_photo)
            }
        }
    }

    override fun getItemCount(): Int = moviesList.size

}