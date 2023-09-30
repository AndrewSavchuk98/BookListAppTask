package com.savchuk.booklistapptask.presentation.screens.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.savchuk.booklistapptask.ui.theme.TextSecondColor

@Composable
fun CategoriesCard(
    name: String,
    publishedDate: String,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onCardClick),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = name, style = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontSize = 18.sp
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = publishedDate,
                textAlign = TextAlign.End,
                style = TextStyle(
                    fontFamily = FontFamily.Serif,
                    color = TextSecondColor
                )
            )
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun CategoriesCardPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CategoriesCard(
            name = "Combined Print and E-Book Fiction",
            publishedDate = "2023-10-08",
            onCardClick = {}
        )
    }

}