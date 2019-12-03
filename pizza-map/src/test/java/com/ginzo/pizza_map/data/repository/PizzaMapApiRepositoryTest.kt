package com.ginzo.pizza_map.data.repository

import arrow.core.Either
import com.ginzo.pizza_map.data.api.PizzaMapRestApi
import com.ginzo.pizza_map.data.entities.DataEntity
import com.ginzo.pizza_map.data.entities.ImageEntity
import com.ginzo.pizza_map.data.entities.ListEntity
import com.ginzo.pizza_map.data.entities.PlaceEntity
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.After
import org.junit.Test
import retrofit2.Response

class PizzaMapApiRepositoryTest {
    private val apiRest: PizzaMapRestApi = mock()

    private val places = listOf(
        PlaceEntity(
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
                ImageEntity(
                    id = "14ceafa9-ad8e-4426-9f29-e452fd06e70f",
                    url = "http://deitaliaan.com/uploads/_photoGalleryFull/316/restaurant_de_italiaan_amsterdam_terras.jpg",
                    caption = "http://deitaliaan.com/uploads/_photoGalleryFull/316/restaurant_de_italiaan_amsterdam_terras.jpg",
                    expiration = "http://deitaliaan.com/uploads/_photoGalleryFull/316/restaurant_de_italiaan_amsterdam_terras.jpg"
                )
            ),
            friendIds = listOf("1", "2", "3", "4", "5")
        )
    )

    private val pizzaMapApiRepository = PizzaMapApiRepository(apiRest)

    @After
    fun tearDown() {
        verifyNoMoreInteractions(apiRest)
    }

    @Test
    fun getProducts_OK() {
        whenever(apiRest.getPizzaPlaces()).thenReturn(
            Single.just(
                Response.success(
                    DataEntity(
                        ListEntity(places)
                    )
                )
            )
        )

        pizzaMapApiRepository.getPizzaPlaces()
            .test()
            .assertValue(Either.right(places.map { it.toDomain() }))

        verify(apiRest).getPizzaPlaces()
    }
}