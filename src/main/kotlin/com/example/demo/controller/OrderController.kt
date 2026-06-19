package com.example.demo.controller

//import com.example.demo.db.Db
import com.example.demo.service.OrderService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

data class Order(val id: Long)
data class CreateOrderRequest(val name: String)

//http通信を受け取る、というアノテーション
@RestController
class OrderController(private val orderService: OrderService) {
    //このエンドポイントにアクセスがきたらこのメソッドを呼び出す、という紐付け
    @GetMapping("/orders/{id}")
    fun getOrder(@PathVariable id: Long): ResponseEntity<Order> {
        val order = orderService.getOrder(id)
        return ResponseEntity.status(201).body(order)
    }

    @PostMapping("/orders")
    fun createOrder(@RequestBody request: CreateOrderRequest): Order {
        return Order(1)
    }

//    @GetMapping("/paces")
//    fun getPaces(): ResponseEntity<List<*>> {
//        val list = Db.list()
//        return ResponseEntity.status(201).body(list)

//    }
}