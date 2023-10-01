package com.savchuk.booklistapptask.presentation.screens.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.savchuk.booklistapptask.R
import com.savchuk.booklistapptask.ui.theme.TextSecondColor

@Composable
fun BookCard(
    name: String,
    description: String,
    author: String,
    publisher: String,
    image: String,
    rank: Int,
    modifier: Modifier = Modifier,
    onShowClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                AsyncImage(
                    modifier = Modifier
                        .width(100.dp)
                        .height(130.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    model = image,
                    contentDescription = stringResource(R.string.book_image),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        //    .fillMaxWidth()
                        .padding(start = 8.dp)
                        .width(160.dp)
                ) {
                    Text(
                        text = name, style = TextStyle(
                            fontFamily = FontFamily.Serif,
                            fontSize = 18.sp
                        )
                    )
                    DefaultText(
                        text = description
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                DefaultText(
                    text = stringResource(R.string.rank, rank)
                )
            }
            Row(
                modifier = Modifier.padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    DefaultText(
                        modifier = Modifier.width(200.dp),
                        text = stringResource(R.string.author, author)
                    )
                    DefaultText(
                        modifier = Modifier.width(200.dp),
                        text = stringResource(R.string.publisher, publisher)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                OutlinedButton(
                    shape = RoundedCornerShape(8.dp),
                    onClick = onShowClick) {
                    Text(text = stringResource(R.string.text_button_buy))
                }
            }
        }
    }
}

@Composable
fun DefaultText(text: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = text, style = TextStyle(
            fontFamily = FontFamily.Serif,
            color = TextSecondColor,
            fontStyle = FontStyle.Italic
        )
    )
}

//As a user, I want to see at least the book's name, description, author, publisher, image, and rank.
// Additionally, there should be a link to buy this book. The link has to be opened inside the app.
@Preview(showBackground = true)
@Composable
fun BookCardPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        BookCard(
            name = "Dorian Gray",
            description = "This is awesome Book,",
            author = "Jul Wern",
            publisher = "Bucha City dsdasdsaaaaasasasasaasas",
            image = "",
            rank = 1
        )
    }
}