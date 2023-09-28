package com.savchuk.booklistapptask.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.savchuk.booklistapptask.data.local.entity.BookCategoryEntity

@Dao
interface BookDao {

    @Query("SELECT * FROM book_category")
    suspend fun getBooksCategories(): List<BookCategoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooksCategories(list: List<BookCategoryEntity>)

    @Delete
    suspend fun deleteAllCategory(list: List<BookCategoryEntity>)

}