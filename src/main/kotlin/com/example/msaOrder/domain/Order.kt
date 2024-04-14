package com.example.msaOrder.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var userId: Long,
    var userName: String? = null,
    var product: String,
    var quantity: Int,
    var createDate: LocalDateTime = LocalDateTime.now()
)