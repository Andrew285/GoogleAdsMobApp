package com.example.taskforapptech.views

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.taskforapptech.R
import com.example.taskforapptech.admob.AdMob
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    private var appBarConfiguration: AppBarConfiguration? = null
    private var drawerLayout: DrawerLayout? = null
    private var toolbar: Toolbar? = null
    private var navController: NavController? = null
    private lateinit var mAdView : AdView
    companion object {
        var mInterstitialAd: InterstitialAd? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        //Navigation Drawer
        drawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment? ?: return

        navController = host.navController
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
            ), drawerLayout
        )

        setupActionBar(navController!!, appBarConfiguration!!)
        navView.setupWithNavController(navController!!)

        supportActionBar?.title = "Home"
        host.childFragmentManager.addFragmentOnAttachListener { _, fragment ->
            AdMob.showInterstitialAd(this)  //show ads

            when (navController!!.currentDestination?.id)
            {
                R.id.homeFragment -> title = "Home"
                R.id.moviesFragment -> title = "Movies"
                R.id.catBreedsFragment -> title = "Cat Breeds"
                R.id.weatherFragment -> title = "Weather"
            }
            supportActionBar?.title = title
        }

        //Setting Up Ads
        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        AdMob.showInterstitialAd(this)  //show ads

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController(R.id.fragmentContainerView))
                || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration!!) || super.onSupportNavigateUp()
    }

    private fun setupActionBar(navController: NavController,
                               appBarConfig : AppBarConfiguration) {
        setupActionBarWithNavController(navController, appBarConfig)
    }
}