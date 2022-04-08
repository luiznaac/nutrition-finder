package com.rafaelfo.nutritionfinder

data class NutritionProportion(
    val portion: Int,
    val proteins: Float? = null,
    val carbs: Float? = null,
)
