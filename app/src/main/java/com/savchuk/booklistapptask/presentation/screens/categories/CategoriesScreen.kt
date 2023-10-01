package com.savchuk.booklistapptask.presentation.screens.categories

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.savchuk.booklistapptask.domain.models.BookCategory
import com.savchuk.booklistapptask.presentation.screens.components.CategoriesCard
import com.savchuk.booklistapptask.presentation.screens.components.ErrorComponent
import com.savchuk.booklistapptask.presentation.screens.components.LoadingComponent

@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier,
    viewModel: CategoriesViewModel = hiltViewModel(),
    onCardClick: (String) -> Unit
) {
    val state = viewModel.state.collectAsState()

    when (state.value) {
        is MainCategoryState.Error -> {
            val data = (state.value as MainCategoryState.Error).data
            if (data != null) {
                CategoryContent(list = data, onCardClick = { onCardClick(it) }, modifier = modifier)
            } else {
                ErrorComponent(
                    errorText = (state.value as MainCategoryState.Error).massage,
                    onRetryClick = { viewModel.fetchRequest() }
                )
            }
        }

        MainCategoryState.Loading -> LoadingComponent()

        is MainCategoryState.Success -> {
            CategoryContent(
                list = (state.value as MainCategoryState.Success).list,
                onCardClick = { onCardClick(it) },
                modifier = modifier
            )
        }
    }
}

@Composable
fun CategoryContent(
    list: List<BookCategory>,
    onCardClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        items(list) {
            CategoriesCard(
                name = it.name,
                publishedDate = it.lastPublishedDate,
                onCardClick = { onCardClick(it.name) }
            )
        }
    }
}