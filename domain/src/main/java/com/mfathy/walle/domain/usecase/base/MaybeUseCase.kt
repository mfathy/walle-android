package com.mfathy.walle.domain.usecase.base

import com.mfathy.walle.domain.extensions.isNetworkError
import io.reactivex.Maybe

abstract class MaybeUseCase<Result : BaseUseCase.Result> : BaseUseCase {
    abstract fun buildUseCase(params: BaseUseCase.Params): Maybe<BaseUseCase.Result>
    fun execute(params: BaseUseCase.Params): Maybe<BaseUseCase.Result> {
        return buildUseCase(params)
            .onErrorReturn {
                if (it.isNetworkError())
                    getNetworkError()
                else
                    getUnknownError()
            }
    }
}