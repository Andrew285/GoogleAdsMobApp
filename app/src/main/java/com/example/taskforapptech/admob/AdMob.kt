package com.example.taskforapptech.admob

import android.content.Context
import android.util.Log
import com.example.taskforapptech.views.MainActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

object AdMob {
    private lateinit var adRequest: AdRequest

    fun showInterstitialAd(context: Context) {
        val adRequest = AdRequest.Builder().build()

        //InterstitialAds
        InterstitialAd.load(
            context,"ca-app-pub-3940256099942544/1033173712",
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d("TAG", adError.toString())
                    MainActivity.mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d("TAG", "Ad was loaded.")
                    MainActivity.mInterstitialAd = interstitialAd
                }
            })
    }
}