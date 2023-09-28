package com.savchuk.booklistapptask.data.remote

import com.savchuk.booklistapptask.data.remote.models.BookResponse
import retrofit2.http.GET

interface BookApi {

    @GET("/names.json")
    suspend fun getBooksCategoryResponse(): BookResponse
}
