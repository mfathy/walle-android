package com.mfathy.walle.domain.usecase

import com.mfathy.walle.domain.PhotosRepository
import com.mfathy.walle.domain.models.Photo
import com.mfathy.walle.domain.usecase.GetPhotosUseCase.*
import com.mfathy.walle.domain.usecase.base.BaseUseCase
import com.mfathy.walle.domain.usecase.base.BaseUseCase.*
import com.mfathy.walle.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val photosRepository: PhotosRepository
) : SingleUseCase<PhotosResult>() {

    override fun buildUseCase(params: Params): Single<Result> {
        return photosRepository.getPhotos().map { PhotosResult.Success(it) }
    }

    override fun getNetworkError(): Result = PhotosResult.Failure(Error.NetworkError)

    override fun getUnknownError(): Result = PhotosResult.Failure(Error.UnknownError)

    /**
     * Results of the use case
     */
    sealed class PhotosResult : Result {
        data class Success(val photos: List<Photo>) : PhotosResult()
        data class Failure(val error: Error) : PhotosResult()
    }
}
