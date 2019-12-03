package com.ginzo.pizza_map.domain.entities

data class Place(
    val id: String,
    val name: String,
    val phone: String,
    val website: String,
    val address: String,
    val city: String,
    val openingHours: List<String>,
    val longitude: Double,
    val latitude: Double,
    val images: List<Image>,
    val friendIds: List<String>
)