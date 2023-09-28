package com.savchuk.booklistapptask.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_category")
data class BookCategoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val newestPublishedDate: String,
    val oldestPublishedDate: String,
    val updated: String
)
