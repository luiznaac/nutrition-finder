package com.monstro.nutritionfinder

class InMemoryFoodRepository : FoodRepository {

    private var persistedFoods: MutableSet<Food> = mutableSetOf()

    override fun save(foods: Set<Food>) {
        persistedFoods.addAll(foods)
    }

    override fun getFoodsBy(proteinProportion: NutritionProportion) =
        persistedFoods
            .filter { it.protein/it.portion >= proteinProportion.has/proteinProportion.each }
            .toSet()
}
