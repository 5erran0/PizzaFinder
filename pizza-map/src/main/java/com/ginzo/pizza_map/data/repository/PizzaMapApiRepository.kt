package com.ginzo.pizza_map.data.repository

import com.ginzo.pizza_map.data.api.PizzaMapRestApi
import javax.inject.Inject

class PizzaMapApiRepository @Inject constructor(
    private val restApi: PizzaMapRestApi
) {
    fun getPizzaPlaces() {

    }
}