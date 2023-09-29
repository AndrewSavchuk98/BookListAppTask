package com.savchuk.booklistapptask.data.remote.models.books

data class Book(
    val amazon_product_url: String,
    val author: String,
    val book_image: String,
    val book_uri: String,
    val buy_links: List<BuyLink>,
    val contributor: String,
    val description: String,
    val price: String,
    val publisher: String,
    val rank: Int,
    val title: String,
)
