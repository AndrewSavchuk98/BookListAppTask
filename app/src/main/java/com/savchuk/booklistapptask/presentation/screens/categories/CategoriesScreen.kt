package com.savchuk.booklistapptask.presentation.screens.categories

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CategoriesScreen(
    viewModel: CategoriesViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {

    LazyColumn {
    }
}