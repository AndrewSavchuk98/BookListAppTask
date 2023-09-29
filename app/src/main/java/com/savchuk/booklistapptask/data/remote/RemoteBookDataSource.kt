package com.savchuk.booklistapptask.data.remote

import com.savchuk.booklistapptask.data.BooKCategoryDataModel
import com.savchuk.booklistapptask.data.BookDataModel
import com.savchuk.booklistapptask.data.BookDataSource
import com.savchuk.booklistapptask.data.remote.models.books.Book
import com.savchuk.booklistapptask.data.remote.models.category.CategoryResult
import com.savchuk.booklistapptask.domain.Mapper
import com.savchuk.booklistapptask.domain.ServerNotRespond
import retrofit2.HttpException
import javax.inject.Inject

interface RemoteBookDataSource : BookDataSource {

    class Base @Inject constructor(
        private val bookApi: BookApi,
        private val mapper: Mapper<CategoryResult, BooKCategoryDataModel>,
        private val bookMapper: Mapper<Book, BookDataModel>
    ) : RemoteBookDataSource {

        override suspend fun getBookCategory(): List<BooKCategoryDataModel> {
            return try {
                bookApi.getBooksCategoryResponse().results.map {
                    mapper.map(it)
                }
            } catch (e: HttpException) {
                throw ServerNotRespond()
            } catch (e: Exception) {
                throw IllegalStateException()
            }
        }

        override suspend fun getBooksList(listName: String): List<BookDataModel> {
            return try {
                bookApi.getBookList(listName = listName).results.books.map {
                    bookMapper.map(it)
                }
            } catch (e: HttpException) {
                throw ServerNotRespond()
            } catch (e: Exception) {
                throw IllegalStateException()
            }
        }
    }
}