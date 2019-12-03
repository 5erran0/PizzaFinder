package com.ginzo.pizza_map.di

import com.ginzo.pizza_map.data.api.PizzaMapRestApi
import com.ginzo.pizza_map.data.repository.PizzaMapDataRepository
import com.ginzo.pizza_map.domain.repository.PizzaMapRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class PizzaMapModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        internal fun providesPizzaMapApiRest(retrofit: Retrofit): PizzaMapRestApi {
            return retrofit.create(PizzaMapRestApi::class.java)
        }
    }

    @Binds
    abstract fun providesPizzaMapRepository(repository: PizzaMapDataRepository): PizzaMapRepository

}