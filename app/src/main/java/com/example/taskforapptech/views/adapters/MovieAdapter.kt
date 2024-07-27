package com.example.taskforapptech.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taskforapptech.databinding.MovieListItemBinding
import com.example.taskforapptech.model.Movie

class MovieAdapter(var context: Context, private var movieList: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    private lateinit var binding: MovieListItemBinding

    class MyViewHolder(private var binding: MovieListItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.movie = movie
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = MovieListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie: Movie = movieList[position]
        holder.bind(movie)

        val imagePath = "https://image.tmdb.org/t/p/w500/${movie.getPosterPath()}"
        Glide.with(context)
            .load(imagePath)
            .into(binding.imageView)

    }
}