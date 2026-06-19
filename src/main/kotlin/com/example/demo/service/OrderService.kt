package com.example.demo.service

import com.example.demo.controller.Order

interface OrderService {
    fun getOrder(id: Long): Order
}