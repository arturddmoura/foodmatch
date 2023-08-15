package com.example.foodmatchcompose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDefaults.contentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.foodmatchcompose.screens.CartScreen
import com.example.foodmatchcompose.screens.HomeScreen
import com.example.foodmatchcompose.screens.ProfileScreen

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    var selectedItem = rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomAppBar {
                BottomNavigation {
                    BottomNavigationItem(
                        selected = selectedItem.value == 0,
                        onClick = { selectedItem.value = 0 },
                        label = {
                            Text(text = "Início", color = if (selectedItem.value == 0) Color.Black else Color.White)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_home),
                                contentDescription = "Início",
                                tint = if (selectedItem.value == 0) Color.Black else Color.White
                            )
                        }
                    )
                    BottomNavigationItem(
                        selected = selectedItem.value == 1,
                        onClick = { selectedItem.value = 1 },
                        label = {
                            Text(text = "Carrinho", color = if (selectedItem.value == 1) Color.Black else Color.White)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_cart),
                                contentDescription = "Carrinho",
                                tint = if (selectedItem.value == 1) Color.Black else Color.White
                            )
                        }
                    )
                    BottomNavigationItem(
                        selected = selectedItem.value == 2,
                        onClick = { selectedItem.value = 2 },
                        label = {
                            Text(text = "Perfil", color = if (selectedItem.value == 2) Color.Black else Color.White)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_profile),
                                contentDescription = "Perfil",
                                tint = if (selectedItem.value == 2) Color.Black else Color.White
                            )
                        }
                    )
                }
            }
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            when (selectedItem.value) {
                0 -> HomeScreen()
                1 -> CartScreen()
                2 -> ProfileScreen()
            }
        }
    }
}