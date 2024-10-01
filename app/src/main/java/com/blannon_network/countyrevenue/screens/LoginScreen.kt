package com.blannon_network.countyrevenue.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.blannon_network.countyrevenue.R

class LoginScreen():Screen {

    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    override fun Content() {


        var navigator = LocalNavigator.current

        var username by remember {
            mutableStateOf("")
        }

        var password by remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Image(
                painter = painterResource(id = R.drawable.county_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(shape = CircleShape)
            )

            Spacer(
                modifier = Modifier
                    .height(6.dp)
            )
            OutlinedTextField(
                value = username,
                onValueChange = {
                    username = it
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,

                        )
                },
                label = {
                    Text(
                        "Username",
                        color = Color.Black
                    )
                }
            )

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        "Password",
                        color = Color.Black
                    )
                },
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )

            OutlinedButton(
                modifier = Modifier
                    .width(300.dp),
                onClick = {
                    navigator?.push(HomeScreen())
                }
            ) {
                Text(
                    "Login",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
            }
            Spacer(Modifier.height(16.dp))

            Text(
                "Forgot Password ?",
                modifier = Modifier
                    .clickable { }
            )
        }
    }
}