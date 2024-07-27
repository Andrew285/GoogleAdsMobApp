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
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.example.taskforapptech.viewmodels.MainActivityViewModel
import com.example.taskforapptech.R
import com.example.taskforapptech.databinding.FragmentMoviesBinding
import com.example.taskforapptech.model.Movie
import com.example.taskforapptech.views.adapters.MovieAdapter
import java.util.ArrayList

class MoviesFragment : Fragment() {
    private lateinit var binding: FragmentMoviesBinding
    private lateinit var viewModel: MainActivityViewModel
    private var movies: ArrayList<Movie>? = null
    private var movieAdapter: MovieAdapter? = null
    private var swipeRefreshLayout: SwipeRefreshLayout? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        getPopularMovies()

//        swipeRefreshLayout = binding.swipeLayout
//        swipeRefreshLayout!!.setColorSchemeResources(R.color.black)
//        swipeRefreshLayout!!.setOnRefreshListener(OnRefreshListener { getPopularMovies() })
    }

    private fun getPopularMovies() {
        viewModel.allMovies.observe(requireActivity(), object : Observer<List<Movie?>?> {
            override fun onChanged(value: List<Movie?>?) {
                movies = value as ArrayList<Movie>?
                displayMoviesInRecyclerView()
            }
        })
    }

    private fun displayMoviesInRecyclerView() {
        recyclerView = binding.recyclerView
        movieAdapter = MovieAdapter(requireContext(), movies!!)
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.adapter = movieAdapter
        recyclerView!!.layoutManager = GridLayoutManager(context, 2)
        movieAdapter!!.notifyDataSetChanged()
    }
}