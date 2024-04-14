package com.example.msaOrder.application

import com.example.msaOrder.api.dto.UserResponse
import com.example.msaOrder.domain.Order
import com.example.msaOrder.domain.repository.OrderRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository,
    private val restTemplate: RestTemplate
) : OrderService {
    override fun getAllOrders(): List<Order> {
        return orderRepository.findAll()
    }

    override fun addOrder(order: Order): Order {
        val userUrl = "http://localhost:8080/users/${order.userId}"
        val response = restTemplate.getForEntity(userUrl, UserResponse::class.java)

        if (response.statusCode == HttpStatus.OK) {
            response.body?.let {
                order.userName = it.name
                return orderRepository.save(order)
            } ?: throw RuntimeException("User not found")
        } else {
            throw RuntimeException("Failed to retrieve user information")
        }
    }
}