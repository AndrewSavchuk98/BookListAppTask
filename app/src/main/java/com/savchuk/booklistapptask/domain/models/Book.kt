package com.savchuk.booklistapptask.domain.models

data class Book(
    val name: String,
    val description: String,
    val author: String,
    val publisher: String,
    val image: String,
    val rank: Int,
    val linkToBuy: List<BookLink>
)
