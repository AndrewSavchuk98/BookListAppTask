package com.savchuk.booklistapptask.data.remote.models

data class BookCategoryResponse(
    val categoryResults: List<CategoryResult>,
    val status: String
)