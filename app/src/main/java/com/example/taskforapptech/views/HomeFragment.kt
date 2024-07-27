package com.example.taskforapptech.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskforapptech.R
import com.example.taskforapptech.databinding.FragmentHomeBinding
import com.example.taskforapptech.views.MainActivity.Companion.mInterstitialAd

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.let {
            it.moviesBtn.setOnClickListener {
                showInterstitialAds()
                findNavController().navigate(R.id.action_homeFragment_to_moviesFragment, null)
            }

            it.catBreedsBtn.setOnClickListener {
                showInterstitialAds()
                findNavController().navigate(R.id.action_homeFragment_to_catBreedsFragment, null)
            }

            it.weatherBtn.setOnClickListener {
                showInterstitialAds()
                findNavController().navigate(R.id.action_homeFragment_to_weatherFragment, null)
            }
        }
    }

    private fun showInterstitialAds() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(requireActivity())
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.")
        }
    }

}