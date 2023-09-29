package com.savchuk.booklistapptask.data.remote

import com.savchuk.booklistapptask.data.BooKCategoryDataModel
import com.savchuk.booklistapptask.data.BookDataModel
import com.savchuk.booklistapptask.data.LinkDataModel
import com.savchuk.booklistapptask.data.remote.models.books.Book
import com.savchuk.booklistapptask.data.remote.models.category.CategoryResult
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

class BookRemoteToDataMapper : Mapper<Book, BookDataModel> {
    override fun map(data: Book): BookDataModel {
        return BookDataModel(
            rank = data.rank,
            title = data.title,
            author = data.author,
            bookImage = data.book_image,
            description = data.description,
            contributor = data.contributor,
            price = data.price,
            amazonProductUrl = data.amazon_product_url,
            bookUri = data.book_uri,
            publisher = data.publisher,
            buyLinks = data.buy_links.map { LinkDataModel(name = it.name, link = it.url) }
        )
    }

}