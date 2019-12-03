package com.ginzo.pizza_map.di

import com.ginzo.remote.RemoteComponent
import dagger.Component

@Component(
    dependencies = [RemoteComponent::class],
    modules = [PizzaMapModule::class]
)
interface PizzaMapComponent {
    @Component.Factory
    interface Factory {
        fun create(remoteComponent: RemoteComponent): PizzaMapComponent
    }
}