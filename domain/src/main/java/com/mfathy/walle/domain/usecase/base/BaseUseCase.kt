package com.mfathy.walle.domain.usecase.base

/**
 * Created by Mohammed Fathy.
 * dev.mfathy@gmail.com
 */
interface BaseUseCase {

    fun getNetworkError(): Result
    fun getUnknownError(): Result

    interface Params
    interface Result

    sealed class Error {
        object NetworkError : Error()
        object UnknownError : Error()
    }
}