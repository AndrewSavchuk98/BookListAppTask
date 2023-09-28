package com.savchuk.booklistapptask.data

import com.savchuk.booklistapptask.data.remote.RemoteBookDataSource
import com.savchuk.booklistapptask.domain.AppException
import com.savchuk.booklistapptask.domain.AppResult
import com.savchuk.booklistapptask.domain.BookRepository
import com.savchuk.booklistapptask.domain.models.BookCategory

class BaseBookRepositoryIml(
    private val remoteBookDataSource: RemoteBookDataSource
) : BookRepository {
    override suspend fun getBookCategory(): AppResult<List<BookCategory>> {
        return try {
            val result = remoteBookDataSource.getBookCategory()
            AppResult.Success(result)
        } catch (e: AppException) {
            AppResult.Error(e.message)
        }
    }
}