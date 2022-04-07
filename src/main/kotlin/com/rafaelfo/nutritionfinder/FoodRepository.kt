package com.rafaelfo.nutritionfinder

interface FoodRepository {

    fun save(foods: Set<Food>)
    fun getFoodsBy(proteinProportion: NutritionProportion): Set<Food>
}
