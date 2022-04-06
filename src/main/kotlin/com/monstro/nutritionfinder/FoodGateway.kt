package com.monstro.nutritionfinder

interface FoodGateway {

    fun getFoodsBy(proteinProportion: NutritionProportion): Set<Food>
}