package com.themgi.docs.coffee

import org.springframework.data.repository.CrudRepository

interface CoffeeRepository : CrudRepository<Coffee, String>