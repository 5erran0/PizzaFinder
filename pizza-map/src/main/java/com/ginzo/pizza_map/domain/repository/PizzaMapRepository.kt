package com.ginzo.pizza_map.domain.repository

import arrow.core.Either
import com.ginzo.pizza_map.domain.entities.Place
import io.reactivex.Single

interface PizzaMapRepository {
    fun getPizzaPlaces(): Single<Either<Throwable, List<Place>>>
}