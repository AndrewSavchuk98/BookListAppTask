package com.savchuk.booklistapptask.data.remote

import com.savchuk.booklistapptask.data.BookDataSource
import com.savchuk.booklistapptask.domain.ServerNotRespond
import com.savchuk.booklistapptask.domain.models.BookCategory
import retrofit2.HttpException
import java.lang.IllegalStateException

interface RemoteBookDataSource : BookDataSource {

    class Base(private val bookApi: BookApi) : RemoteBookDataSource {
        override suspend fun getBookCategory(): List<BookCategory> {
            return try {
                bookApi.getBooksCategoryResponse().results.map {
                    BookCategory(
                        name = it.display_name,
                        lastPublishedDate = it.oldest_published_date
                    )
                }
            } catch (e: HttpException) {
                throw ServerNotRespond()
            } catch (e: Exception) {
                throw IllegalStateException()
                //todo replace with handle exception
            }
        }
    }
}