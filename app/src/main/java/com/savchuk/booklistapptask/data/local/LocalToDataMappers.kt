package com.savchuk.booklistapptask.data.local

import com.savchuk.booklistapptask.data.BooKCategoryDataModel
import com.savchuk.booklistapptask.data.local.entity.BookCategoryEntity
import com.savchuk.booklistapptask.domain.Mapper

class CategoryLocalToDataMapper : Mapper<BookCategoryEntity, BooKCategoryDataModel> {
    override fun map(data: BookCategoryEntity): BooKCategoryDataModel {
        return BooKCategoryDataModel(
            name = data.name,
            newestPublishedDate = data.newestPublishedDate,
            oldestPublishedDate = data.oldestPublishedDate,
            updated = data.updated
        )
    }
}