package com.savchuk.booklistapptask.domain.use_cases

import com.savchuk.booklistapptask.domain.AppResult
import com.savchuk.booklistapptask.domain.BookRepository
import com.savchuk.booklistapptask.domain.models.BookCategory
import javax.inject.Inject

interface GetBookCategoriesUseCase {

    suspend fun invoke(): AppResult<List<BookCategory>>

    class Base @Inject constructor(
        private val repository: BookRepository
    ) : GetBookCategoriesUseCase {
        override suspend fun invoke(): AppResult<List<BookCategory>> {
            return repository.getBookCategory()
        }
    }
}