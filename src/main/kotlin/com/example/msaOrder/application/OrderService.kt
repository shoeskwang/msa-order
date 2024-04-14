package com.example.msaOrder.application

import com.example.msaOrder.domain.Order

interface OrderService {
    fun getAllOrders(): List<Order>
    fun addOrder(order: Order): Order
}