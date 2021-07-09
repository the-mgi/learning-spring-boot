package com.themgi.docs.coffee

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/coffees")
class CoffeeController(private val coffeeRepository: CoffeeRepository) {
    @GetMapping
    fun getCoffees(): Iterable<Coffee> {
        return this.coffeeRepository.findAll()
    }

    @GetMapping("/{id}")
    fun getCoffeeById(@PathVariable id: String): Optional<Coffee> {
        return this.coffeeRepository.findById(id)
    }

    @PostMapping
    fun postCoffee(@RequestBody coffee: Coffee): ResponseEntity<Coffee> {
        return ResponseEntity(this.coffeeRepository.save(coffee), HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun putCoffee(@PathVariable id: String, @RequestBody coffee: Coffee): ResponseEntity<Coffee> {
        return if (this.coffeeRepository.existsById(id)) {
            ResponseEntity(this.coffeeRepository.save(coffee), HttpStatus.OK)
        } else {
            ResponseEntity(this.coffeeRepository.save(coffee), HttpStatus.CREATED)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteCoffee(@PathVariable id: String) {
        this.coffeeRepository.deleteById(id)
    }
}