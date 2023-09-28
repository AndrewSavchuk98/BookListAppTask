package com.savchuk.booklistapptask.domain

import com.savchuk.booklistapptask.domain.models.BookCategory

interface BookRepository {

    suspend fun getBookCategory(): AppResult<List<BookCategory>>

}