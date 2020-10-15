package com.mfathy.walle.domain.usecase

import com.mfathy.walle.domain.PhotosRepository
import com.mfathy.walle.domain.models.Photo
import com.mfathy.walle.domain.usecase.base.BaseUseCase
import com.mfathy.walle.domain.usecase.base.BaseUseCase.Error
import com.mfathy.walle.domain.usecase.base.BaseUseCase.Result
import com.mfathy.walle.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetPhotoUseCase @Inject constructor(
    private val photosRepository: PhotosRepository
) : SingleUseCase<GetPhotoUseCase.PhotoResult>() {

    override fun buildUseCase(params: BaseUseCase.Params): Single<Result> {
        return photosRepository.getPhoto().map { PhotoResult.Success(it) }
    }

    override fun getNetworkError(): Result = PhotoResult.Failure(Error.NetworkError)

    override fun getUnknownError(): Result = PhotoResult.Failure(Error.NetworkError)

    /**
     * Results of the use case
     */
    sealed class PhotoResult : Result {
        data class Success(val photo: Photo) : PhotoResult()
        data class Failure(val error: Error) : PhotoResult()
    }
}