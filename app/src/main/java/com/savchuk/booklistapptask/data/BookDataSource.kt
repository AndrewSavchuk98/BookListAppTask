package com.savchuk.booklistapptask.data

interface BookDataSource {

    suspend fun getBookCategory(): List<BooKCategoryDataModel>
}