package com.example.msaOrder.api

import com.example.msaOrder.application.OrderService
import com.example.msaOrder.domain.Order
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController(
    val orderService: OrderService
) {
    @GetMapping
    fun getAllOrders(): List<Order> = orderService.getAllOrders()

    @PostMapping
    fun addOrder(@RequestBody order: Order): Order = orderService.addOrder(order)
}