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

    private val _state = MutableStateFlow<MainCategoryState>(MainCategoryState.Loading)
    val state: StateFlow<MainCategoryState> get() = _state

    init {
        fetchRequest()
    }

    fun fetchRequest() {
        viewModelScope.launch {
            when (val result = useCase.invoke()) {
                is AppResult.Error -> _state.value =
                    MainCategoryState.Error(result.message.orEmpty(), result.data)
                is AppResult.Loading -> _state.value = MainCategoryState.Loading
                is AppResult.Success -> _state.value =
                    MainCategoryState.Success(result.data ?: emptyList())
            }
        }
    }

}

sealed class MainCategoryState {
    object Loading : MainCategoryState()
    data class Success(val list: List<BookCategory>) : MainCategoryState()
    data class Error(val massage: String, val data: List<BookCategory>?) : MainCategoryState()
}

sealed class CategoryEvent {
    object EnterScreen : CategoryEvent()
    object ReloadScreen : CategoryEvent()
}