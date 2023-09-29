package com.savchuk.booklistapptask.data

import com.savchuk.booklistapptask.domain.models.Book
import com.savchuk.booklistapptask.domain.models.BookLink


data class BookDataModel(
    val amazonProductUrl: String,
    val author: String,
    val bookImage: String,
    val bookUri: String,
    val buyLinks: List<LinkDataModel>,
    val contributor: String,
    val description: String,
    val price: String,
    val publisher: String,
    val rank: Int,
    val title: String,
) {

    fun mapToDomain(): Book {
        return Book(
            name = title,
            description = description,
            author = author,
            publisher = publisher,
            image = bookImage,
            rank = rank,
            linkToBuy = buyLinks.map { BookLink(it.name, it.link) }
        )

    }
}