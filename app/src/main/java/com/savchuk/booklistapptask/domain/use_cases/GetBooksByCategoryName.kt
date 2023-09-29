package com.savchuk.booklistapptask.domain.use_cases

import com.savchuk.booklistapptask.domain.AppResult
import com.savchuk.booklistapptask.domain.BookRepository
import com.savchuk.booklistapptask.domain.models.Book
import javax.inject.Inject

interface GetBooksByCategoryName {
    suspend fun invoke(listName: String): AppResult<List<Book>>

    class Base @Inject constructor(
        private val repository: BookRepository
    ) : GetBooksByCategoryName {
        override suspend fun invoke(listName: String): AppResult<List<Book>> {
            return repository.getBooksListByName(listName)
        }

    }
}