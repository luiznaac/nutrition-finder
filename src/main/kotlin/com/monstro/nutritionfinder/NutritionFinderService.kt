package com.monstro.nutritionfinder

class NutritionFinderService(
    private val foodGateway: FoodGateway,
) {

    fun findFoodsBy(portion: Int, protein: Int): Set<Food> {
        return foodGateway.getFoodsBy(
            NutritionProportion(
                each = portion,
                has = protein,
            )
        )
    }
}
