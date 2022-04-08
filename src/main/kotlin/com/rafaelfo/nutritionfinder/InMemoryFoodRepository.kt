package com.rafaelfo.nutritionfinder

class InMemoryFoodRepository : FoodRepository {

    private var persistedFoods: MutableSet<Food> = mutableSetOf()

    override fun save(foods: Set<Food>) {
        persistedFoods.addAll(foods)
    }

    override fun getFoodsBy(proportion: NutritionProportion, searchType: SearchType) =
        persistedFoods
            .filter { it.filterProteins(proportion, searchType) }
            .filter { it.filterCarbs(proportion, searchType) }
            .filter { it.filterFats(proportion, searchType) }
            .toSet()
}

private fun Food.filterProteins(proportion: NutritionProportion, searchType: SearchType): Boolean {
    if(proportion.proteins == null) return true

    val range = proportion.range(proportion.proteins, 10)

    return when(searchType) {
        SearchType.AT_LEAST -> proteins/portion >= proportion.proteins/proportion.portion
        SearchType.AROUND -> proteins/portion in range
    }
}

private fun Food.filterCarbs(proportion: NutritionProportion, searchType: SearchType): Boolean {
    if(proportion.carbs == null) return true

    return carbs/portion >= proportion.carbs/proportion.portion
}

private fun Food.filterFats(proportion: NutritionProportion, searchType: SearchType): Boolean {
    if(proportion.fats == null) return true

    return fats/portion >= proportion.fats/proportion.portion
}

private fun NutritionProportion.range(macroValue: Float, factor: Int): ClosedFloatingPointRange<Float> {
    val minFactor = ((100-factor)/100F)
    val maxFactor = ((100+factor)/100F)
    return ((macroValue/portion) * minFactor)..((macroValue/portion) * maxFactor)
}
