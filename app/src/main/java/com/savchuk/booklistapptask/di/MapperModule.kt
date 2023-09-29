package com.savchuk.booklistapptask.di

import com.savchuk.booklistapptask.data.BooKCategoryDataModel
import com.savchuk.booklistapptask.data.BookDataModel
import com.savchuk.booklistapptask.data.local.CategoryLocalToDataMapper
import com.savchuk.booklistapptask.data.local.entity.BookCategoryEntity
import com.savchuk.booklistapptask.data.remote.BookRemoteToDataMapper
import com.savchuk.booklistapptask.data.remote.CategoryRemoteToDataMapper
import com.savchuk.booklistapptask.data.remote.models.books.Book
import com.savchuk.booklistapptask.data.remote.models.category.CategoryResult
import com.savchuk.booklistapptask.domain.Mapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

    @Provides
    @Singleton
    fun provideCategoryRemoteToDataMapper(): Mapper<CategoryResult, BooKCategoryDataModel> =
        CategoryRemoteToDataMapper()

    @Provides
    @Singleton
    fun provideBookRemoteToDataMapper(): Mapper<Book, BookDataModel> =
        BookRemoteToDataMapper()

    @Provides
    @Singleton
    fun provideLocalToDataMapper(): Mapper<BookCategoryEntity, BooKCategoryDataModel> =
        CategoryLocalToDataMapper()
}