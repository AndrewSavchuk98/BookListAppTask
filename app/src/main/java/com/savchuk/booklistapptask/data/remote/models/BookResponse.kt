package com.savchuk.booklistapptask.data.remote.models

data class BookResponse(
    val results: List<Result>,
    val status: String
)