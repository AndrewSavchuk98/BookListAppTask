package com.savchuk.booklistapptask.presentation.screens.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.savchuk.booklistapptask.domain.AppResult
import com.savchuk.booklistapptask.domain.models.BookCategory
import com.savchuk.booklistapptask.domain.use_cases.GetBookCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val useCase: GetBookCategoriesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CategoryState())
    val state: StateFlow<CategoryState> get() = _state

    init {
        viewModelScope.launch {
            when (val result = useCase.invoke()) {
                is AppResult.Error -> {

                }

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

data class CategoryState(
    val list: List<BookCategory> = emptyList(),
    val isLoading: Boolean = false
)