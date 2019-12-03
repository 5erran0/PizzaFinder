package com.ginzo.pizza_map.di

import com.ginzo.pizza_map.data.api.PizzaMapRestApi
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

}