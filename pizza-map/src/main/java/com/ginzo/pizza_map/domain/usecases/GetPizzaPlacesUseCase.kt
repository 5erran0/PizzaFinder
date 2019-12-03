package com.ginzo.pizza_map.domain.usecases

import arrow.core.Either
import com.ginzo.pizza_map.domain.entities.Place
import com.ginzo.pizza_map.domain.repository.PizzaMapRepository
import io.reactivex.Single
import javax.inject.Inject

class GetPizzaPlacesUseCase @Inject constructor(
    private val repository: PizzaMapRepository
) {
    fun getPizzaPlaces(): Single<Either<Throwable, List<Place>>> {
        return repository.getPizzaPlaces()
    }
}