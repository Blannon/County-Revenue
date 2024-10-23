package com.blannon_network.countyrevenue.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class RevenueStreams : Screen {

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        Box(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()

            ) {

                OutlinedButton(
                    modifier = Modifier
                        .width(650.dp)
                        .height(75.dp),
                    shape = RoundedCornerShape(1.dp),
                    colors = ButtonDefaults.buttonColors(Color.White),
                    onClick = {

                    }
                ) {
                    Text(
                        "Check CESS Compliance",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(start = 3.dp)
                    )
                }

                Spacer(Modifier.height(16.dp))

                OutlinedButton(
                    modifier = Modifier
                        .width(620.dp)
                        .height(75.dp)
                        .padding(start = 15.dp, end = 15.dp),
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(1.dp),
                    onClick = {
                        navigator?.push(CessPoints())
                    }
                ) {
                    Text(
                        "Cess",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}
