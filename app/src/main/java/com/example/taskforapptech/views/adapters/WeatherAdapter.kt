package com.example.taskforapptech.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskforapptech.databinding.WeatherListItemBinding
import com.example.taskforapptech.model.Weather

class WeatherAdapter(var context: Context, private var weatherData: List<Weather>):
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {
    private lateinit var binding: WeatherListItemBinding

    class ViewHolder(private var binding: WeatherListItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(weather: Weather) {
            binding.textViewDay.text = "Day: " + weather.getDay()
            binding.textViewTemperature.text = "Temperature: " + weather.getTemperature()
            binding.textViewWind.text = "Wind: " + weather.getWind()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = WeatherListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return weatherData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val weatherData = weatherData.get(position)
        holder.bind(weatherData)
    }

}