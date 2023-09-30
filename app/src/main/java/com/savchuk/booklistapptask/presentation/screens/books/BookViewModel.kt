package com.savchuk.booklistapptask.presentation.screens.books

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.savchuk.booklistapptask.domain.AppResult
import com.savchuk.booklistapptask.domain.models.Book
import com.savchuk.booklistapptask.domain.use_cases.GetBooksByCategoryName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val useCase: GetBooksByCategoryName
) : ViewModel() {

    private val listName: String = checkNotNull(savedStateHandle["listName"])

    private val _state = MutableStateFlow(BookState())
    val state: StateFlow<BookState> get() = _state

    init {
        viewModelScope.launch {
            when (val result = useCase.invoke(listName)) {
                is AppResult.Error -> TODO()
                is AppResult.Loading -> {
                    _state.value = _state.value.copy(
                        list = result.data ?: emptyList(),
                        isLoading = true
                    )
                }

                is AppResult.Success -> {
                    _state.value = _state.value.copy(
                        list = result.data ?: emptyList(),
                        isLoading = false
                    )
                }
            }
        }
    }

}

data class BookState(
    val list: List<Book> = emptyList(),
    val isLoading: Boolean = false
)