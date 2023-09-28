package com.savchuk.booklistapptask.data

import com.savchuk.booklistapptask.data.local.LocalBookDataSource
import com.savchuk.booklistapptask.data.remote.RemoteBookDataSource
import com.savchuk.booklistapptask.domain.AppException
import com.savchuk.booklistapptask.domain.AppResult
import com.savchuk.booklistapptask.domain.BookRepository
import com.savchuk.booklistapptask.domain.models.BookCategory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BaseBookRepositoryImpl @Inject constructor(
    private val remoteBookDataSource: RemoteBookDataSource,
    private val localBookDataSource: LocalBookDataSource,
    private val dispatcher: CoroutineDispatcher
) : BookRepository {

    override suspend fun getBookCategory(): AppResult<List<BookCategory>> =
        withContext(dispatcher) {
            val localCategory = localBookDataSource.getBookCategory()
            return@withContext try {
                val remoteCategory =  remoteBookDataSource.getBookCategory()
                localBookDataSource.deleteAllCategory(remoteCategory)
                localBookDataSource.insertBookCategories(remoteCategory)
                AppResult.Success(remoteCategory.map { it.toDomainModel() })
            } catch (e: AppException) {
                AppResult.Error(e.message, localCategory.map { it.toDomainModel() })
            }
        }
}