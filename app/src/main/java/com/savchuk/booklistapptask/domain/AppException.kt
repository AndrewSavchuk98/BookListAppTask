package com.savchuk.booklistapptask.domain

abstract class AppException : Throwable()

class ServerNotRespond: AppException()

class NoInternetConnection: AppException()

