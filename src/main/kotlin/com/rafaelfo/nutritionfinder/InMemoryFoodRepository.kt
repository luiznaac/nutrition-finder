package com.rafaelfo.nutritionfinder

class InMemoryFoodRepository : FoodRepository {

    private var persistedFoods: MutableSet<Food> = mutableSetOf()

    override fun save(foods: Set<Food>) {
        persistedFoods.addAll(foods)
    }

    override fun getFoodsBy(proportion: NutritionProportion) =
        persistedFoods
            .filter { it.filterProteins(proportion) }
            .filter { it.filterCarbs(proportion) }
            .filter { it.filterFats(proportion) }
            .toSet()
}

private fun Food.filterProteins(proportion: NutritionProportion): Boolean {
    if(proportion.proteins == null) return true

    return proteins/portion >= proportion.proteins/proportion.portion
}

private fun Food.filterCarbs(proportion: NutritionProportion): Boolean {
    if(proportion.carbs == null) return true

    return carbs/portion >= proportion.carbs/proportion.portion
}

private fun Food.filterFats(proportion: NutritionProportion): Boolean {
    if(proportion.fats == null) return true

    return fats/portion >= proportion.fats/proportion.portion
}
