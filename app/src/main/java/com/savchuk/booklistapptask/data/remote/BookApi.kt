package com.savchuk.booklistapptask.data.remote

import com.savchuk.booklistapptask.data.remote.models.category.BookCategoryResponse
import com.savchuk.booklistapptask.data.remote.models.books.BooksResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BookApi {

    @GET("names.json")
    suspend fun getBooksCategoryResponse(): BookCategoryResponse

    @GET("{date}/{list}.json")
    suspend fun getBookList(
        @Path("date") date: String = "current",
        @Path("list") listName: String
    ): BooksResponse
}
