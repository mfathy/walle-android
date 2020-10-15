package com.mfathy.walle.domain.extensions

import com.mfathy.walle.domain.exceptions.NetworkException

/**
 * Created by Mohammed Fathy.
 * dev.mfathy@gmail.com
 */

fun Throwable.isNetworkError(): Boolean {
    return (this is NetworkException)
}