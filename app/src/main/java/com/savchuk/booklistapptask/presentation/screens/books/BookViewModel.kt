package com.savchuk.booklistapptask.presentation.screens.books

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.savchuk.booklistapptask.domain.models.Book
import com.savchuk.booklistapptask.domain.use_cases.GetBooksByCategoryName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val useCase: GetBooksByCategoryName
) : ViewModel() {

    private val _state = MutableStateFlow(BookState())
    val state: StateFlow<BookState> get() = _state

    init {
        viewModelScope.launch {

        }
    }

}

data class BookState(
    val list: List<Book> = emptyList()
)