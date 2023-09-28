package com.savchuk.booklistapptask.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.savchuk.booklistapptask.data.local.entity.BookCategoryEntity

@Database(
    entities = [BookCategoryEntity::class],
    version = 1
)
abstract class BookDataBase: RoomDatabase() {
    abstract fun bookDao(): BookDao
}