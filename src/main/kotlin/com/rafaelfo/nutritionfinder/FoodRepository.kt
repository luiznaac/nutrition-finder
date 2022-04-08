package com.rafaelfo.nutritionfinder

interface FoodRepository {

    fun save(foods: Set<Food>)
    fun getFoodsBy(proportion: NutritionProportion): Set<Food>
}
