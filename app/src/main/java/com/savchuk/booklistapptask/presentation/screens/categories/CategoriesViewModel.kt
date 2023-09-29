package com.savchuk.booklistapptask.presentation.screens.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.savchuk.booklistapptask.domain.models.BookCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    //private val useCase: GetBookCategoriesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CategoryState())
    val state: StateFlow<CategoryState> get() = _state

    init {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                //list = useCase.invoke()
            )
        }
    }

}

data class CategoryState(
    val list: List<BookCategory> = emptyList()
)