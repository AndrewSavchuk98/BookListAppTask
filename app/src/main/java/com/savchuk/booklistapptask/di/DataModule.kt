package com.savchuk.booklistapptask.di

import com.savchuk.booklistapptask.data.BaseBookRepositoryImpl
import com.savchuk.booklistapptask.domain.BookRepository
import com.savchuk.booklistapptask.domain.use_cases.GetBookCategoriesUseCase
import com.savchuk.booklistapptask.domain.use_cases.GetBooksByCategoryName
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindBookUseCase(getBooksByCategoryName: GetBooksByCategoryName.Base):
            GetBooksByCategoryName

    @Binds
    fun bindBookCategoryUseCase(useCase: GetBookCategoriesUseCase.Base):
            GetBookCategoriesUseCase

    @Binds
    fun bindBookRepository(repository: BaseBookRepositoryImpl):
            BookRepository

}