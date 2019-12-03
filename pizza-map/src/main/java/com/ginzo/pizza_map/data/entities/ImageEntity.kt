package com.ginzo.pizza_map.data.entities

import com.ginzo.pizza_map.domain.entities.Image
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageEntity(
    val id: String,
    val url: String,
    val caption: String,
    val expiration: String
) {
    fun toDomain(): Image {
        return Image(id, url)
    }
}