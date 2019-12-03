package com.ginzo.pizza_map.domain.usecases

import arrow.core.Either
import com.ginzo.pizza_map.data.repository.PizzaMapDataRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.After
import org.junit.Test

class GetPizzaPlacesUseCaseTest {
    private val repository: PizzaMapDataRepository = mock()

    private val usecase = GetPizzaPlacesUseCase(repository)

    @After
    fun tearDown() {
        verifyNoMoreInteractions(repository)
    }

    @Test
    fun getPizzaPlaces_ok() {
        whenever(repository.getPizzaPlaces()).thenReturn(Single.just(Either.right(emptyList())))

        usecase.getPizzaPlaces()
            .test()
            .assertValue(Either.right(emptyList()))

        verify(repository).getPizzaPlaces()
    }

    @Test
    fun getPizzaPlaces_ko() {
        val throwable = Throwable()
        whenever(repository.getPizzaPlaces()).thenReturn(Single.just(Either.left(throwable)))

        usecase.getPizzaPlaces()
            .test()
            .assertValue(Either.left(throwable))

        verify(repository).getPizzaPlaces()
    }
}