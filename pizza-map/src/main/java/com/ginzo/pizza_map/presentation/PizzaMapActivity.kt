package com.ginzo.pizza_map.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ginzo.pizza_map.R

class PizzaMapActivity : AppCompatActivity(), PizzaMapView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_map)
    }
}
