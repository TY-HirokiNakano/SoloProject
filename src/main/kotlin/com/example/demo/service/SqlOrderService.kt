package com.example.demo.service

import com.example.demo.controller.Order
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Service
class SqlOrderService : OrderService {
    override fun getOrder(id: Long): Order {
        return Order(id)
    }
}