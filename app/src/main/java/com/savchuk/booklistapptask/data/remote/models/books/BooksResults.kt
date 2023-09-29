package com.savchuk.booklistapptask.data.remote.models.books

data class BooksResults(
    val bestsellers_date: String,
    val books: List<Book>,
    val display_name: String,
    val list_name: String,
    val published_date: String,
    val updated: String
)