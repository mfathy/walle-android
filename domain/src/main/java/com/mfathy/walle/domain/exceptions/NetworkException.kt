package com.mfathy.walle.domain.exceptions

import java.io.IOException

/**
 * Created by Mohammed Fathy.
 * dev.mfathy@gmail.com
 */
class NetworkException(throwable: IOException) : BaseException(throwable)