package com.savchuk.booklistapptask.data

import com.savchuk.booklistapptask.data.local.entity.BookCategoryEntity
import com.savchuk.booklistapptask.domain.models.BookCategory

data class BooKCategoryDataModel(
    val name: String,
    val newestPublishedDate: String,
    val oldestPublishedDate: String,
    val updated: String
) {
    fun toLocalEntity(): BookCategoryEntity {
        return BookCategoryEntity(
            name = name,
            newestPublishedDate = newestPublishedDate,
            oldestPublishedDate = oldestPublishedDate,
            updated = updated
        )
    }

    fun toDomainModel(): BookCategory {
        return BookCategory(
            name = name,
            lastPublishedDate = oldestPublishedDate
        )
    }
}
