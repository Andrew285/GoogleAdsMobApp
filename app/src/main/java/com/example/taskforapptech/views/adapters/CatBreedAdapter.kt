package com.example.taskforapptech.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskforapptech.databinding.CatBreedListItemBinding
import com.example.taskforapptech.model.CatBreed

class CatBreedAdapter(var context: Context, private var catBreeds: List<CatBreed>):
    RecyclerView.Adapter<CatBreedAdapter.ViewHolder>() {
    private lateinit var binding: CatBreedListItemBinding

    class ViewHolder(private var binding: CatBreedListItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(catBreed: CatBreed) {
            binding.cat = catBreed
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = CatBreedListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return catBreeds.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val catBreed = catBreeds.get(position)
        holder.bind(catBreed)
    }

}