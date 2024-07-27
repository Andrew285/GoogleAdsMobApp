package com.example.taskforapptech.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskforapptech.R
import com.example.taskforapptech.admob.AdMob
import com.example.taskforapptech.databinding.FragmentCatBreedsBinding
import com.example.taskforapptech.model.CatBreed
import com.example.taskforapptech.model.Movie
import com.example.taskforapptech.viewmodels.MainActivityViewModel
import com.example.taskforapptech.views.adapters.CatBreedAdapter
import com.example.taskforapptech.views.adapters.MovieAdapter
import java.util.ArrayList

class CatBreedsFragment : Fragment() {
    private lateinit var binding: FragmentCatBreedsBinding
    private lateinit var viewModel: MainActivityViewModel
    private var catBreeds: ArrayList<CatBreed>? = null
    private var catBreedAdapter: CatBreedAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCatBreedsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        getCatBreeds()
    }

    private fun getCatBreeds() {
        viewModel.allCatBreeds.observe(requireActivity(), object : Observer<List<CatBreed?>?> {
            override fun onChanged(value: List<CatBreed?>?) {
                catBreeds = value as ArrayList<CatBreed>?
                displayCatBreedsInRecyclerView()
            }
        })
    }

    private fun displayCatBreedsInRecyclerView() {
        catBreedAdapter = CatBreedAdapter(requireContext(), catBreeds!!)
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        binding.recyclerView.adapter = catBreedAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        catBreedAdapter!!.notifyDataSetChanged()
    }
}