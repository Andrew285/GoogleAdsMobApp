package com.example.taskforapptech.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskforapptech.databinding.FragmentWeatherBinding
import com.example.taskforapptech.model.Weather
import com.example.taskforapptech.viewmodels.MainActivityViewModel
import com.example.taskforapptech.views.adapters.WeatherAdapter
import java.util.ArrayList

class WeatherFragment : Fragment() {
    private lateinit var binding: FragmentWeatherBinding
    private lateinit var viewModel: MainActivityViewModel
    private var weatherData: ArrayList<Weather>? = null
    private var weatherAdapter: WeatherAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        getWeatherData()
    }

    private fun getWeatherData() {
        viewModel.allWeatherData.observe(requireActivity(), object : Observer<List<Weather?>?> {
            override fun onChanged(value: List<Weather?>?) {
                weatherData = value as ArrayList<Weather>?
                displayWeatherDataInRecyclerView()
            }
        })
    }

    private fun displayWeatherDataInRecyclerView() {
        weatherAdapter = WeatherAdapter(requireContext(), weatherData!!)
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        binding.recyclerView.adapter = weatherAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        weatherAdapter!!.notifyDataSetChanged()
    }
}