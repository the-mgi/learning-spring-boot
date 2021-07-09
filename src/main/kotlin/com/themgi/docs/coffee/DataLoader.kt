package com.themgi.docs.coffee

import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class DataLoader(private val coffeeRepository: CoffeeRepository) {

    @PostConstruct
    fun loadData() {
        this.coffeeRepository.saveAll(
            mutableListOf(
                Coffee("Latte"),
                Coffee("Cappuccino"),
                Coffee("Nescafe"),
                Coffee("Roasted Black Coffee"),
            )
        )
    }
}