package com.ginzo.pizza_map.data.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ListEntity(
    val places: List<PlaceEntity>
)