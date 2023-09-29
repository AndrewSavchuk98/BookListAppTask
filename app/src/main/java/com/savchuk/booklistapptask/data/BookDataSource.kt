package com.savchuk.booklistapptask.data

interface BookDataSource {

    suspend fun getBookCategory(): List<BooKCategoryDataModel>

    suspend fun getBooksList(listName: String): List<BookDataModel>
}