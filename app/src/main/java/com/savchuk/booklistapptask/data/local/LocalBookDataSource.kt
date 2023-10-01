package com.savchuk.booklistapptask.data.local

import com.savchuk.booklistapptask.data.BooKCategoryDataModel
import com.savchuk.booklistapptask.data.BookDataModel
import com.savchuk.booklistapptask.data.BookDataSource
import com.savchuk.booklistapptask.data.local.entity.BookCategoryEntity
import com.savchuk.booklistapptask.data.local.entity.BookEntity
import com.savchuk.booklistapptask.domain.Mapper
import javax.inject.Inject

interface LocalBookDataSource : BookDataSource {

    suspend fun insertBookCategories(list: List<BooKCategoryDataModel>)

    suspend fun deleteAllCategory(list: List<BooKCategoryDataModel>)

    suspend fun insertBooks(list: List<BookDataModel>, listName: String)

    suspend fun deleteBooks(list: List<BookDataModel>)

    class Base @Inject constructor(
        private val dao: BookDao,
        private val mapper: Mapper<BookCategoryEntity, BooKCategoryDataModel>
    ) : LocalBookDataSource {

        override suspend fun insertBookCategories(list: List<BooKCategoryDataModel>) {
            dao.insertBooksCategories(list.map {
                it.toLocalEntity()
            })
        }

        override suspend fun deleteAllCategory(list: List<BooKCategoryDataModel>) {
            dao.deleteAllCategory(list.map { it.toLocalEntity() })
        }

        override suspend fun insertBooks(list: List<BookDataModel>, listName: String) {
            dao.insertBooks(list.map {
                BookEntity(
                    title = it.title,
                    author = it.author,
                    bookImage = it.bookImage,
                    bookUri = it.bookUri,
                    amazonProductUrl = it.amazonProductUrl,
                    contributor = it.contributor,
                    description = it.description,
                    price = it.price,
                    publisher = it.publisher,
                    rank = it.rank,
                    listName = listName
                )
            })
        }

        override suspend fun deleteBooks(list: List<BookDataModel>) {
            dao.deleteAllBooks(list.map { it.mapToLocal() })
        }

        override suspend fun getBookCategory(): List<BooKCategoryDataModel> {
            return try {
                dao.getBooksCategories().map {
                    mapper.map(it)
                }
            } catch (e: Exception) {
                throw IllegalStateException(e)
            }
        }

        override suspend fun getBooksList(listName: String): List<BookDataModel> {
            val list = dao.getBooksWithLinks(listName)

            return list.map {
                BookDataModel(
                    title = it.title,
                    author = it.author,
                    bookImage = it.bookImage,
                    bookUri = it.bookUri,
                    amazonProductUrl = it.amazonProductUrl,
                    contributor = it.contributor,
                    description = it.description,
                    price = it.price,
                    publisher = it.publisher,
                    buyLinks = emptyList(),
                    rank = it.rank
                )
            }
        }
    }
}