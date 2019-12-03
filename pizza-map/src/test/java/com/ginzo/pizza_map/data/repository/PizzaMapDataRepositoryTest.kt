package com.ginzo.pizza_map.data.repository

import arrow.core.Either
import com.ginzo.pizza_map.domain.entities.Image
import com.ginzo.pizza_map.domain.entities.Place
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.After
import org.junit.Test

class PizzaMapDataRepositoryTest {
    private val apiRepository: PizzaMapApiRepository = mock()

    private val dataRepository = PizzaMapDataRepository(apiRepository)

    private val places = listOf(
        Place(
            id = "1",
            name = "De Italiaan",
            phone = "+31 20 683 6854",
            website = "http://deitaliaan.com/",
            address = "Bosboom Toussaintstraat 29, 1054 AN Amsterdam, Netherlands",
            city = "Amsterdam",
            openingHours = listOf(
                "Monday: 5:30 â€“ 10:00 PM",
                "Tuesday: 5:30 â€“ 10:00 PM",
                "Wednesday: 5:30 â€“ 10:00 PM",
                "Thursday: 5:30 â€“ 10:00 PM",
                "Friday: 5:30 â€“ 10:00 PM",
                "Saturday: 12:00 â€“ 4:00 PM, 5:30 â€“ 10:00 PM",
                "Sunday: 12:00 â€“ 4:00 PM, 5:30 â€“ 10:00 PM"
            ),
            longitude = 4.876391399999999,
            latitude = 52.36549829999999,
            images = listOf(
                Image(
                    id = "14ceafa9-ad8e-4426-9f29-e452fd06e70f",
                    url = "http://deitaliaan.com/uploads/_photoGalleryFull/316/restaurant_de_italiaan_amsterdam_terras.jpg"
                )
            ),
            friendIds = listOf("1", "2", "3", "4", "5")
        )
    )

    @After
    fun tearDown() {
        verifyNoMoreInteractions(apiRepository)
    }

    @Test
    fun getProducts_ok() {
        whenever(apiRepository.getPizzaPlaces()).thenReturn(
            Single.just(Either.right(places))
        )

        dataRepository.getPizzaPlaces()
            .test()
            .assertValue(Either.right(places))

        verify(apiRepository).getPizzaPlaces()
    }

    @Test
    fun getProducts_ko() {
        val throwable = Throwable()
        whenever(apiRepository.getPizzaPlaces()).thenReturn(Single.just(Either.left(throwable)))

        dataRepository.getPizzaPlaces()
            .test()
            .assertValue(Either.left(throwable))

        verify(apiRepository).getPizzaPlaces()
    }
}