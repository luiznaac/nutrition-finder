package com.rafaelfo.nutritionfinder

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class FoodRepositoryTest: StringSpec({

    val repository: FoodRepository = InMemoryFoodRepository()

    "test get foods by nutrition portion - filtering protein" {
        val patinhoMoido = Food(
            name = "Patinho moído", portion = 100, calories = 141F, carbs = 2.8F, proteins = 21F, fats = 4.4F
        )
        val bananaCaturra = Food(
            name = "Banana caturra", portion = 100, calories = 97F, carbs = 22.2F, proteins = 1.2F, fats = 0.4F
        )
        repository.save(setOf(patinhoMoido, bananaCaturra))

        val foundFoods = repository.getFoodsBy(
            NutritionProportion(portion = 50, proteins = 10F)
        )

        foundFoods shouldBe setOf(patinhoMoido)
    }

    "test get foods by nutrition portion - filtering carbs" {
        val patinhoMoido = Food(
            name = "Patinho moído", portion = 100, calories = 141F, carbs = 2.8F, proteins = 21F, fats = 4.4F
        )
        val bananaCaturra = Food(
            name = "Banana caturra", portion = 100, calories = 97F, carbs = 22.2F, proteins = 1.2F, fats = 0.4F
        )
        repository.save(setOf(patinhoMoido, bananaCaturra))

        val foundFoods = repository.getFoodsBy(
            NutritionProportion(portion = 10, carbs = 2F)
        )

        foundFoods shouldBe setOf(bananaCaturra)
    }

    "test get foods by nutrition portion - filtering fats" {
        val patinhoMoido = Food(
            name = "Patinho moído", portion = 100, calories = 141F, carbs = 2.8F, proteins = 21F, fats = 4.4F
        )
        val bananaCaturra = Food(
            name = "Banana caturra", portion = 100, calories = 97F, carbs = 22.2F, proteins = 1.2F, fats = 0.4F
        )
        repository.save(setOf(patinhoMoido, bananaCaturra))

        val foundFoods = repository.getFoodsBy(
            NutritionProportion(portion = 100, fats = 2F)
        )

        foundFoods shouldBe setOf(patinhoMoido)
    }
})
