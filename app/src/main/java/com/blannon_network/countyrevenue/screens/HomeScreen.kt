package com.blannon_network.countyrevenue.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocalParking
import androidx.compose.material.icons.filled.Report
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.blannon_network.countyrevenue.R

class HomeScreen: Screen {

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        Scaffold { paddingValues ->
            Column(
                Modifier
                    .background(Color.DarkGray)
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                FeatureCard(
                    icon = Icons.Default.LocalParking,
                    label = "Parking"
                )
                FeatureCard(
                    icon = Icons.Default.DateRange,
                    label = "Revenue Streams",
                    iconSize = 40,
                    onClick = {
                        navigator?.push(RevenueStreams())
                    }
                )
                FeatureCardWithImage(
                    imageResId = R.drawable.county_logo,
                    label = "Bill Verification",
                    onClick = {
                        navigator?.push(BillVerification())
                    }

                )
                FeatureCardWithImage(
                    imageResId = R.drawable.county_logo,
                    label = "Account Management"
                )
                FeatureCard(
                    icon = Icons.Default.Report,
                    label = "Reports"
                )
            }
        }
    }
}

@Composable
fun FeatureCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    iconSize: Int = 30,
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .padding(10.dp)
            .clickable { onClick?.invoke() },
    ) {
        Box(
            Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    Modifier.size(iconSize.dp),
                    Color.Black
                )
                Spacer(Modifier.height(6.dp))
                Text(label)
            }
        }
    }
}

@Composable
fun FeatureCardWithImage(
    imageResId: Int,
    label: String,
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .padding(10.dp)
            .clickable { onClick?.invoke() },
    ) {
        Box(
            Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
                Spacer(Modifier.height(6.dp))
                Text(label)
            }
        }
    }
}
