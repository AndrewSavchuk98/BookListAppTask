package com.savchuk.booklistapptask.data.remote

import com.savchuk.booklistapptask.data.BooKCategoryDataModel
import com.savchuk.booklistapptask.data.remote.models.CategoryResult
import com.savchuk.booklistapptask.domain.Mapper

class CategoryRemoteToDataMapper : Mapper<CategoryResult, BooKCategoryDataModel> {
    override fun map(data: CategoryResult): BooKCategoryDataModel {
        return BooKCategoryDataModel(
            name = data.list_name,
            newestPublishedDate = data.newest_published_date,
            oldestPublishedDate = data.oldest_published_date,
            updated = data.updated
        )
    }
}