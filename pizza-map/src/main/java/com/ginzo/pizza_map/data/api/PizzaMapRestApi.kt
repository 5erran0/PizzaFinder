package com.ginzo.pizza_map.data.api

import com.ginzo.pizza_map.data.entities.DataEntity
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface PizzaMapRestApi {
    @GET
    fun getPizzaPlaces(): Single<Response<DataEntity>>
}