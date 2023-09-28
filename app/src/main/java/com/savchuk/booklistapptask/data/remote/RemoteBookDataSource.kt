package com.savchuk.booklistapptask.data.remote

import com.savchuk.booklistapptask.data.BooKCategoryDataModel
import com.savchuk.booklistapptask.data.BookDataSource
import com.savchuk.booklistapptask.data.remote.models.CategoryResult
import com.savchuk.booklistapptask.domain.Mapper
import com.savchuk.booklistapptask.domain.ServerNotRespond
import retrofit2.HttpException
import javax.inject.Inject

interface RemoteBookDataSource : BookDataSource {

    class Base @Inject constructor(
        private val bookApi: BookApi,
        private val mapper: Mapper<CategoryResult, BooKCategoryDataModel>
    ) : RemoteBookDataSource {
        override suspend fun getBookCategory(): List<BooKCategoryDataModel> {
            return try {
                bookApi.getBooksCategoryResponse().categoryResults.map {
                    mapper.map(it)
                }
            } catch (e: HttpException) {
                throw ServerNotRespond()
            } catch (e: Exception) {
                throw IllegalStateException()
            }
        }
    }
}