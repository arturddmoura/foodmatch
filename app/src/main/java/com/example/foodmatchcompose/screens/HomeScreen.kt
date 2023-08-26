package com.example.foodmatchcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodmatchcompose.R

data class CardItemHome(val title: String, val price: Double, val image: Int)


@Composable
fun HomeScreen() {
    val cartItemsList = listOf(
        CardItemHome("Maçã", 1.0, R.drawable.ic_apple),
        CardItemHome("Banana", 0.5, R.drawable.ic_banana),
        CardItemHome("Morango", 0.8, R.drawable.ic_strawberry)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(40.dp)
    ) {
        LazyColumn {
            items(cartItemsList) { cardItem ->
                Spacer(modifier = Modifier.height(10.dp)) // Add desired padding between items
                ElevatedCard {
                    Column{
                        Image(
                            modifier = Modifier
                                .width(width = 350.dp)
                                .clip(shape = RoundedCornerShape(size = 12.dp)),
                            painter = painterResource(id = cardItem.image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            modifier = Modifier.padding(start = 12.dp, top = 12.dp, bottom = 16.dp),
                            text = cardItem.title,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(
                            modifier = Modifier.padding(start = 12.dp, bottom = 12.dp),
                            text = "Preço: R$ ${cardItem.price}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray
                        )
                        Button(
                            onClick = {
                                //
                            },
                            modifier = Modifier
                                .padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
                                .fillMaxWidth()
                        ) {
                            Text(text = "Adicionar ao carrinho")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}
