package com.blannon_network.countyrevenue.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Parking(){
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                Spacer(modifier = Modifier.height(16.dp)
                    .padding(top = 20.dp))

                Card(
                    Modifier
                        .height(200.dp)
                        .padding(10.dp)

                ) {
                    Box(
                        Modifier
                            .fillMaxSize()

                    ) {
                        Column (
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.White),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,

                            ){
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = null,
                                Modifier.size(40.dp)
                                    .padding(top = 2.dp),
                                Color.Black
                            )

                            Spacer(
                                Modifier
                                    .height(6.dp)
                            )
                            Text(
                                "Revenue Streams",
                            )
                        }

                    }
                }
            }
        }
    )

}