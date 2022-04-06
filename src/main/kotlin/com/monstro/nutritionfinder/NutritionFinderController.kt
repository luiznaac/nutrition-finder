package com.monstro.nutritionfinder

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/find")
class NutritionFinderController {

    @GetMapping
    fun find(): String {
        return "finding food"
    }
}