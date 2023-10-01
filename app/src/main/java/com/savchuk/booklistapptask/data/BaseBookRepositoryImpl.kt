package com.savchuk.booklistapptask.data

import android.util.Log
import com.savchuk.booklistapptask.data.local.LocalBookDataSource
import com.savchuk.booklistapptask.data.remote.RemoteBookDataSource
import com.savchuk.booklistapptask.domain.AppResult
import com.savchuk.booklistapptask.domain.BookRepository
import com.savchuk.booklistapptask.domain.models.Book
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
                val remoteCategory = remoteBookDataSource.getBookCategory()
                localBookDataSource.deleteAllCategory(remoteCategory)
                localBookDataSource.insertBookCategories(remoteCategory)
                Log.d("TAG", "IS $localCategory")
                AppResult.Success(remoteCategory.map { it.toDomainModel() })
            } catch (e: Exception) {
                AppResult.Error(e.message, localCategory.map { it.toDomainModel() })
            }
        }

    override suspend fun getBooksListByName(listName: String): AppResult<List<Book>> =
        withContext(dispatcher) {
            val localBook = localBookDataSource.getBooksList(listName)
            Log.d("TAG", localBook.toString())

            return@withContext try {
                val remoteBook = remoteBookDataSource.getBooksList(listName)
                localBookDataSource.deleteBooks(remoteBook)
                localBookDataSource.insertBooks(remoteBook, listName)
                AppResult.Success(remoteBook.map {
                    it.mapToDomain()
                })
            } catch (e: Exception) {
                Log.d("TAG", e.message.toString())
                AppResult.Error("No Internet Connection", localBook.map { it.mapToDomain() })
            }
        }
}