package com.rafaelfo.nutritionfinder

class InMemoryFoodRepository : FoodRepository {

    private var persistedFoods: MutableSet<Food> = mutableSetOf()

    override fun save(foods: Set<Food>) {
        persistedFoods.addAll(foods)
    }

    override fun getFoodsBy(proportion: NutritionProportion) =
        persistedFoods
            .filter { it.proteins/it.portion >= proportion.protein/proportion.portion }
            .toSet()
}
