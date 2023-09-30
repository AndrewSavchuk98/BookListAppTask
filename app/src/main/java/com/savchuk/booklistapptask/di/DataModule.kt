package com.savchuk.booklistapptask.di

import com.savchuk.booklistapptask.data.BaseBookRepositoryImpl
import com.savchuk.booklistapptask.data.local.LocalBookDataSource
import com.savchuk.booklistapptask.data.remote.RemoteBookDataSource
import com.savchuk.booklistapptask.domain.BookRepository
import com.savchuk.booklistapptask.domain.use_cases.GetBookCategoriesUseCase
import com.savchuk.booklistapptask.domain.use_cases.GetBooksByCategoryName
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun bindBookUseCase(getBooksByCategoryName: GetBooksByCategoryName.Base):
            GetBooksByCategoryName
    @Binds
    @Singleton
    fun bindRemoteDataSource(dataSource: RemoteBookDataSource.Base):
            RemoteBookDataSource
    @Binds
    @Singleton
    fun bindLocalDataSource(dataSource: LocalBookDataSource.Base):
            LocalBookDataSource

    @Binds
    @Singleton
    fun bindBookCategoryUseCase(useCase: GetBookCategoriesUseCase.Base):
            GetBookCategoriesUseCase

    @Binds
    @Singleton
    fun bindBookRepository(repository: BaseBookRepositoryImpl):
            BookRepository

}