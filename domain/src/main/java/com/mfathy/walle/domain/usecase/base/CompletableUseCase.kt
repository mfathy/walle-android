package com.mfathy.walle.domain.usecase.base

import io.reactivex.Completable

abstract class CompletableUseCase<Result : BaseUseCase.Result> : BaseUseCase {
    abstract fun buildUseCase(params: BaseUseCase.Params): Completable
    fun execute(params: BaseUseCase.Params): Completable {
        return buildUseCase(params)
    }
}

