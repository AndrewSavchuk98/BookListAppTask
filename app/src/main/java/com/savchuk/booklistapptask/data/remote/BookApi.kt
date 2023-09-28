package com.savchuk.booklistapptask.data.remote

import com.savchuk.booklistapptask.data.remote.models.BookCategoryResponse
import retrofit2.http.GET

interface BookApi {

    @GET("/names.json")
    suspend fun getBooksCategoryResponse(): BookCategoryResponse
}
