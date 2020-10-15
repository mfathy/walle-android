package com.mfathy.walle.domain.usecase.base

import com.mfathy.walle.domain.extensions.isNetworkError
import io.reactivex.Observable

abstract class ObservableUseCase<Result : BaseUseCase.Result> : BaseUseCase {
    abstract fun buildUseCase(params: BaseUseCase.Params): Observable<BaseUseCase.Result>
    fun execute(params: BaseUseCase.Params): Observable<BaseUseCase.Result> {
        return buildUseCase(params)
            .onErrorReturn {
                if (it.isNetworkError())
                    getNetworkError()
                else
                    getUnknownError()
            }
    }
}