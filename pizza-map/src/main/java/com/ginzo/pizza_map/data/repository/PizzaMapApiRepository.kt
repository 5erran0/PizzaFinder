package com.ginzo.pizza_map.data.repository

import arrow.core.Either
import com.ginzo.pizza_map.data.api.PizzaMapRestApi
import com.ginzo.pizza_map.domain.entities.Place
import com.ginzo.remote.responseToEither
import io.reactivex.Single
import javax.inject.Inject

class PizzaMapApiRepository @Inject constructor(
    private val restApi: PizzaMapRestApi
) {
    fun getPizzaPlaces(): Single<Either<Throwable, List<Place>>> {
        return restApi.getPizzaPlaces()
            .compose(responseToEither { data ->
                data.list.places.map { it.toDomain() }
            })
    }
}