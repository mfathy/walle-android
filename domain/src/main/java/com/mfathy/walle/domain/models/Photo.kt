package com.mfathy.walle.domain.models

/**
 * Created by Mohammed Fathy.
 * dev.mfathy@gmail.com
 *
 */
data class Photo(
    val id: String,
    val created_at: String,
    val updated_at: String,
    val width: Int,
    val height: Int,
    val color: String,
    val downloads: Int,
    val likes: Int,
    val description: String,
    val location: Location,
    val tags: List<Tags>,
    val urls: Urls
)