package com.savchuk.booklistapptask.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.savchuk.booklistapptask.domain.models.BookLink
import com.savchuk.booklistapptask.presentation.screens.components.BookCard
import com.savchuk.booklistapptask.ui.theme.BookListAppTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookListAppTaskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        BookCard(
                            name = "Dorian Gray",
                            description = "This is awesome Book,",
                            author = "Jul Wern",
                            publisher = "Bucha City",
                            image = "",
                            rank = 1,
                            buyLink = listOf(
                                BookLink("Amazon", "https://amazon.com"),
                                BookLink("Google", "https://google.com")
                            )
                        )
                    }

                }
            }
        }
    }
}
