package com.savchuk.booklistapptask.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookEntity(
    @PrimaryKey val title: String,
    val amazonProductUrl: String,
    val author: String,
    val bookImage: String,
    val bookUri: String,
    val contributor: String,
    val description: String,
    val price: String,
    val publisher: String,
    val rank: Int,
    val listName: String
)
