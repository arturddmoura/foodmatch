package com.example.foodmatchcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodmatchcompose.R

data class CartItem(val id: Int, val name: String, val price: Double, val imageUrl: String)

@Composable
fun CartScreen() {
    val cartItems = remember {
        mutableStateListOf(
            CartItem(1, "Maçã", 1.0, "https://cdn.pixabay.com/photo/2016/12/09/15/30/apples-1891589_1280.jpg"),
            CartItem(2, "Banana", 0.5, "https://cdn.pixabay.com/photo/2014/08/12/01/07/bananas-415942_1280.jpg"),
            CartItem(3, "Morango", 0.8, "https://cdn.pixabay.com/photo/2017/08/30/07/56/oranges-2695171_1280.jpg")
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(cartItems) { item ->
                CartItemRow(item, onDelete = { cartItems.remove(item) })
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Handle checkout logic here */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Fechar pedido")
        }
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun CartItemRow(item: CartItem, onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val imageResource = when (item.name) {
            "Maçã" -> R.drawable.ic_apple
            "Banana" -> R.drawable.ic_banana
            "Morango" -> R.drawable.ic_strawberry
            else -> R.drawable.ic_fruit_placeholder
        }

        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .fillMaxSize()
                .background(Color.Transparent)
                .clip(CircleShape)
        )


        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        ) {
            Text(text = item.name, style = MaterialTheme.typography.bodyLarge)
            Text(text = "R$ ${item.price}", style = MaterialTheme.typography.bodyLarge)
        }

        IconButton(onClick = onDelete) {
            Icon(
                painter = painterResource(id = R.drawable.ic_delete),
                contentDescription = "Deletar produto"
            )
        }
    }
}


@Composable
@Preview
fun PreviewCartScreen() {
    CartScreen()
}