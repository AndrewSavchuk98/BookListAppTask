package com.savchuk.booklistapptask.presentation.screens.books

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.savchuk.booklistapptask.domain.AppResult
import com.savchuk.booklistapptask.domain.models.Book
import com.savchuk.booklistapptask.domain.models.BookCategory
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

    private val _state = MutableStateFlow<BookState>(BookState.Loading)
    val state: StateFlow<BookState> get() = _state

    init {
        fetchData()
    }

    fun fetchData(){
        viewModelScope.launch {
            when (val result = useCase.invoke(listName)) {
                is AppResult.Error -> _state.value =
                    BookState.Error(result.message.orEmpty(), result.data)
                is AppResult.Loading -> {
                    _state.value = BookState.Loading
                }

                is AppResult.Success -> {
                    _state.value =
                        BookState.Success(result.data.orEmpty())
                }
            }
        }
    }

}

sealed class BookState {
    object Loading : BookState()
    data class Success(val list: List<Book>) : BookState()
    data class Error(val massage: String, val data: List<Book>?) : BookState()
}