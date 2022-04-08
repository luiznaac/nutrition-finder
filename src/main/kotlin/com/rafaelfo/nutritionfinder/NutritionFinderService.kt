package com.rafaelfo.nutritionfinder

class NutritionFinderService(
    private val foodRepository: FoodRepository,
) {

    fun findFoodsBy(portion: Int, protein: Int): Set<Food> {
        TODO()
    }
}
