package com.savchuk.booklistapptask.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.savchuk.booklistapptask.data.local.entity.BookCategoryEntity
import com.savchuk.booklistapptask.data.local.entity.BookEntity

@Dao
interface BookDao {

    @Query("SELECT * FROM book_category")
    suspend fun getBooksCategories(): List<BookCategoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooksCategories(list: List<BookCategoryEntity>)

    @Delete
    suspend fun deleteAllCategory(list: List<BookCategoryEntity>)

    @Transaction
    @Query("SELECT * FROM BookEntity WHERE listName LIKE :listName")
    suspend fun getBooksWithLinks(listName: String): List<BookEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooks(list: List<BookEntity>)

    @Delete
    suspend fun deleteAllBooks(list: List<BookEntity>)

}