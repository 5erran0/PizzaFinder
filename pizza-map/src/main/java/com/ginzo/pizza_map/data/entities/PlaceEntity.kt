package com.ginzo.pizza_map.data.entities

import com.ginzo.pizza_map.domain.entities.Place
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlaceEntity(
    val id: String,
    val name: String,
    val phone: String,
    val website: String,
    @Json(name = "formattedAddress")
    val address: String,
    val city: String,
    val openingHours: List<String>,
    val longitude: Double,
    val latitude: Double,
    val images: List<ImageEntity>,
    val friendIds: List<String>
) {
    fun toDomain(): Place {
        return Place(id, name, phone, website, address, city, openingHours, longitude, latitude, images.map { it.toDomain() }, friendIds)
    }
}