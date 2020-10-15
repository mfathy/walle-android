package com.mfathy.walle.domain

import com.mfathy.walle.domain.models.Photo
import io.reactivex.Single

/**
 * Created by Mohammed Fathy.
 * dev.mfathy@gmail.com
 */
interface PhotosRepository {
    fun getPhoto(): Single<Photo>
    fun getPhotos(): Single<List<Photo>>
}