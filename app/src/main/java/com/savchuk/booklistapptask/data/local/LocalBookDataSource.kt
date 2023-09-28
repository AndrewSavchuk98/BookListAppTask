package com.savchuk.booklistapptask.data.local

import com.savchuk.booklistapptask.data.BooKCategoryDataModel
import com.savchuk.booklistapptask.data.BookDataSource
import com.savchuk.booklistapptask.data.local.entity.BookCategoryEntity
import com.savchuk.booklistapptask.domain.Mapper
import javax.inject.Inject

interface LocalBookDataSource : BookDataSource {

    suspend fun insertBookCategories(list: List<BooKCategoryDataModel>)

    suspend fun deleteAllCategory(list: List<BooKCategoryDataModel>)

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

        override suspend fun getBookCategory(): List<BooKCategoryDataModel> {
            return try {
                dao.getBooksCategories().map {
                    mapper.map(it)
                }
            } catch (e: Exception) {
                throw IllegalStateException(e)
            }
        }
    }
}