package com.themgi.docs.coffee

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Coffee(private var name: String? = "", @Id var id: String? = UUID.randomUUID().toString())