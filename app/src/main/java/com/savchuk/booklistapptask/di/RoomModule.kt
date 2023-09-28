package com.savchuk.booklistapptask.di

import android.content.Context
import androidx.room.Room
import com.savchuk.booklistapptask.data.local.BookDao
import com.savchuk.booklistapptask.data.local.BookDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideRoomDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            BookDataBase::class.java,
            BOOK_DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun provideNumberFactDao(dataBase: BookDataBase): BookDao =
        dataBase.bookDao()

    companion object {
        private const val BOOK_DATABASE_NAME = "book.db"
    }
}