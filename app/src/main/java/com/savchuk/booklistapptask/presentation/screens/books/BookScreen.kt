package com.savchuk.booklistapptask.presentation.screens.books

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.savchuk.booklistapptask.domain.models.Book
import com.savchuk.booklistapptask.presentation.screens.components.BookCard
import com.savchuk.booklistapptask.presentation.screens.components.LinkDialog
import com.savchuk.booklistapptask.presentation.screens.components.LinkWebView

@Composable
fun BookScreen(
    modifier: Modifier = Modifier,
    viewModel: BookViewModel = hiltViewModel(),
) {
    val state = viewModel.state.collectAsState()
    var showLinksDialog by remember {
        mutableStateOf(false)
    }
    var currentBook by remember {
        mutableStateOf<Book?>(null)
    }

    var showWeb by remember {
        mutableStateOf(false)
    }

    var currentLink by remember {
        mutableStateOf("")
    }

    LazyColumn(modifier = modifier) {
        items(state.value.list) {
            BookCard(
                name = it.name,
                description = it.description,
                author = it.author,
                publisher = it.publisher,
                image = it.image,
                rank = it.rank,
                onShowClick = {
                    showLinksDialog = true
                    currentBook = it
                }
            )
        }
    }

    if (showLinksDialog) {
        currentBook?.linkToBuy?.let {
            LinkDialog(
                onLinkClicked = { link ->
                    showWeb = true
                    currentLink = link
                    showLinksDialog = false
                },
                onDismissRequest = { showLinksDialog = false },
                list = it
            )
        }
    }

    if (showWeb) {
        LinkWebView(url = currentLink, modifier = modifier)
    }

}