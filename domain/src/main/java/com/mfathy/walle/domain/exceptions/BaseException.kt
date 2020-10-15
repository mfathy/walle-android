package com.mfathy.walle.domain.exceptions

/**
 * Created by Mohammed Fathy.
 * dev.mfathy@gmail.com
 */
open class BaseException : RuntimeException {
    constructor() : super()
    constructor(throwable: Throwable) : super(throwable)
}