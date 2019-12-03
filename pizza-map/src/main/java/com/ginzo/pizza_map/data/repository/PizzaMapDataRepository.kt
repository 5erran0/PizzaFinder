package com.ginzo.pizza_map.data.repository

import arrow.core.Either
import com.ginzo.pizza_map.domain.entities.Place
import com.ginzo.pizza_map.domain.repository.PizzaMapRepository
import io.reactivex.Single
import javax.inject.Inject

class PizzaMapDataRepository @Inject constructor(
    private val apiRepository: PizzaMapApiRepository
) : PizzaMapRepository {
    override fun getPizzaPlaces(): Single<Either<Throwable, List<Place>>> {
        return apiRepository.getPizzaPlaces()
    }
}