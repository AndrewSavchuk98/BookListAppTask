package com.savchuk.booklistapptask.domain

abstract class AppException : RuntimeException()

class ServerNotRespond: AppException()

class NotInternetConnection: AppException()

