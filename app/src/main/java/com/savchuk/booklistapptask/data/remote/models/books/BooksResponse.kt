package com.savchuk.booklistapptask.data.remote.models.books

data class BooksResponse(
    val last_modified: String,
    val results: BooksResults,
    val status: String
)