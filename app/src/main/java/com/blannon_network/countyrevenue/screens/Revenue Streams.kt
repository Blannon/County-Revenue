package com.blannon_network.countyrevenue.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen


class RevenueStreams():Screen{

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    override fun Content() {


            Box(Modifier.padding(top = 50.dp)
                .fillMaxSize()){
                Column(
                    Modifier.padding(top = 50.dp)
                ) {

                OutlinedButton(
                    modifier = Modifier
                        .width(400.dp),
                    onClick = {}
                ) {
                    Text("Check CESS Compliance",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )
                }
                Spacer(Modifier.height(16.dp))

                OutlinedButton(
                    modifier = Modifier
                        .width(400.dp)
                        .padding(30.dp),
                    onClick = {}
                ) {
                    Text("Cess",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )
                }
            }

        }
    }
}







