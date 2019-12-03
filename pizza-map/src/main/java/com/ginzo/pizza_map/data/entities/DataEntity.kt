package com.ginzo.pizza_map.data.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataEntity(
    val list: ListEntity
)