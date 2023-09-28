package com.savchuk.booklistapptask.data

import com.savchuk.booklistapptask.domain.models.BookCategory

interface BookDataSource {

    suspend fun getBookCategory(): List<BookCategory>
}