package com.savchuk.booklistapptask.domain

interface Mapper<T, R> {

    fun map(data: T): R
}