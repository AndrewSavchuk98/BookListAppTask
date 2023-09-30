package com.savchuk.booklistapptask.presentation.screens.categories

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.savchuk.booklistapptask.presentation.screens.components.CategoriesCard

@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier,
    viewModel: CategoriesViewModel = hiltViewModel(),
    onCardClick: (String) -> Unit
) {
    val state = viewModel.state.collectAsState()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        items(state.value.list) {
            CategoriesCard(
                name = it.name,
                publishedDate = it.lastPublishedDate,
                onCardClick = { onCardClick(it.name) }
            )
        }
    }
}