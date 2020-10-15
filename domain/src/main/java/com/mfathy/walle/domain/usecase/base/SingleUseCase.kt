package com.mfathy.walle.domain.usecase.base

import com.mfathy.walle.domain.extensions.isNetworkError
import io.reactivex.Single

abstract class SingleUseCase<Result : BaseUseCase.Result> : BaseUseCase {
    abstract fun buildUseCase(params: BaseUseCase.Params): Single<BaseUseCase.Result>
    fun execute(params: BaseUseCase.Params): Single<BaseUseCase.Result> {
        return buildUseCase(params)
            .onErrorReturn {
                if (it.isNetworkError())
                    getNetworkError()
                else
                    getUnknownError()
            }
    }
}