package com.rafaelfo.nutritionfinder

interface FoodRepository {

    fun save(foods: Set<Food>)
    fun getFoodsBy(proportion: NutritionProportion, searchType: SearchType): Set<Food>
}
