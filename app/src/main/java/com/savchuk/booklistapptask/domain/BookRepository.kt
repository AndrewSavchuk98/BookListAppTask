package com.savchuk.booklistapptask.domain

import com.savchuk.booklistapptask.domain.models.Book
import com.savchuk.booklistapptask.domain.models.BookCategory

interface BookRepository {

    suspend fun getBookCategory(): AppResult<List<BookCategory>>

    suspend fun getBooksListByName(listName: String): AppResult<List<Book>>

}