package com.blannon_network.countyrevenue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cafe.adriel.voyager.navigator.Navigator
import com.blannon_network.countyrevenue.screens.HomeScreen
import com.blannon_network.countyrevenue.screens.LoginScreen
import com.blannon_network.countyrevenue.ui.theme.CountyRevenueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        installSplashScreen()
        setContent {
            CountyRevenueTheme {

                Navigator(LoginScreen())

            }
        }
    }
}

