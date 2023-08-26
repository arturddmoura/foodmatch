package com.example.foodmatchcompose

import LoginScreen
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.foodmatchcompose.screens.CartScreen
import com.example.foodmatchcompose.screens.HomeScreen

data class BottomNavigationTab(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

val bottomNavigationTabs = listOf(
    BottomNavigationTab(
        title = "Início",
        selectedIcon = Icons.Default.Home,
        unselectedIcon = Icons.Outlined.Home
    ),
    BottomNavigationTab(
        title = "Carrinho",
        selectedIcon = Icons.Default.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart,
    ),
    BottomNavigationTab(
        title = "Perfil",
        selectedIcon = Icons.Default.Person,
        unselectedIcon = Icons.Outlined.Person,
    ),
)

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }


        Scaffold (
            topBar = {
                AppHeader(title = "FoodMatch")
            },
            bottomBar = {
                BottomAppBar (
                ){
                    bottomNavigationTabs.forEachIndexed { index, tab ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                            },
                            icon = {
                                Icon(
                                    imageVector = if (index == selectedItemIndex) {
                                        tab.selectedIcon
                                    } else tab.unselectedIcon,
                                    contentDescription = tab.title
                                )
                            }
                        )
                    }
                }
            },
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
                    .padding(top = 25.dp, bottom = 25.dp)
            ) {
                when (selectedItemIndex) {
                    0 -> HomeScreen()
                    1 -> CartScreen()
                    2 -> LoginScreen()
                }
            }
        }
    }