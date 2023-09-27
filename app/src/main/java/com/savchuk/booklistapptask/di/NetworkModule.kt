package com.savchuk.booklistapptask.di

import com.savchuk.booklistapptask.data.remote.BookApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/** Don`t use
 * @property API_KEY like this,
 *
 * It`s only for Test Task
 */

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideBookApi(retrofit: Retrofit): BookApi {
        return retrofit.create(BookApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofitBuilder(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val newRequest = originalRequest.newBuilder()
                    .url("${originalRequest.url}?api-key=$API_KEY")
                    .build()
                return@addInterceptor chain.proceed(newRequest)
            }
            .addInterceptor(loggingInterceptor)
            .build()
    }

    private val loggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    companion object {
        private const val BASE_URL = "https://api.nytimes.com/svc/books/v3/lists/"
        private const val API_KEY = "UrdM3pZmiMhn0yPeU7RHMUEGAiO8alBy"
    }
}