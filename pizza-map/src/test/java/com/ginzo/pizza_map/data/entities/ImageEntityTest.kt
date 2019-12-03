package com.ginzo.pizza_map.data.entities

import com.ginzo.pizza_map.domain.entities.Image
import com.squareup.moshi.Moshi
import okio.Okio
import org.junit.Assert
import org.junit.Test

class ImageEntityTest {
    private val moshi: Moshi = Moshi.Builder().build()
    private val jsonAdapter = moshi.adapter<ImageEntity>(ImageEntity::class.java)

    @Test
    fun toDomain_Image() {
        val reader =
            Okio.buffer(Okio.source(javaClass.classLoader!!.getResourceAsStream("json/image.json")!!))
        val item = jsonAdapter.fromJson(reader)!!.toDomain()

        Assert.assertEquals(
            Image(
                id = "14ceafa9-ad8e-4426-9f29-e452fd06e70f",
                url = "http://deitaliaan.com/uploads/_photoGalleryFull/316/restaurant_de_italiaan_amsterdam_terras.jpg"
            ),
            item
        )
    }
}