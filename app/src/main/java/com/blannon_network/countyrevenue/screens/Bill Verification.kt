package com.blannon_network.countyrevenue.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen


class BillVerification():Screen {

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    override fun Content() {

        var BillNumber by remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = BillNumber,
            onValueChange = {
                BillNumber = it
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null,

                    )
            },
            label = {
                Text(
                    "Bill Number",
                    color = Color.Black
                )
            }
        )
    }
}