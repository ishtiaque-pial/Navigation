package com.example.navigationcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.bookingFragment,R.id.notificationFragment,R.id.loyalityFragment,R.id.profileFragment))
        toolbar.setupWithNavController(navController, appBarConfiguration)
        bottomNavigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.flightFragment) {
                bottomNavigation.visibility = GONE
            } else {
                bottomNavigation.visibility = VISIBLE
            }
        }
    }
}