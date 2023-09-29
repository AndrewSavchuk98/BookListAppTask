package com.savchuk.booklistapptask.data.remote.models.category

data class BookCategoryResponse(
    val results: List<CategoryResult>,
    val status: String
)