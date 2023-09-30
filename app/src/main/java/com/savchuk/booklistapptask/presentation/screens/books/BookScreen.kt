package com.savchuk.booklistapptask.presentation.screens.books

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.savchuk.booklistapptask.presentation.screens.components.BookCard

@Composable
fun BookScreen(
    modifier: Modifier = Modifier,
    viewModel: BookViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    LazyColumn(modifier = modifier) {
        items(state.value.list) {
            BookCard(
                name = it.name,
                description = it.description,
                author = it.author,
                publisher = it.publisher,
                image = it.image,
                rank = it.rank,
                buyLink = it.linkToBuy
            )
        }
    }
}