package com.ginzo.pizza_map.data.entities

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
    val friendsIds: List<String>
)