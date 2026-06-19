package com.example.demo.controller

import com.example.demo.db.EPace
import com.example.demo.service.EPaceService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class EPaceController(private val ePaceService: EPaceService) {
    @GetMapping("/paces")
    fun list(): ResponseEntity<List<EPace>> {
        val res = ePaceService.list()
        return ResponseEntity(res, HttpStatus.OK)
    }

    @GetMapping("/paces/{id}")
    fun get(@PathVariable id: Int): ResponseEntity<EPace> {
        val res = ePaceService.get(id)
        return ResponseEntity(res, HttpStatus.OK)
    }

    @PostMapping("/paces")
    fun add(@RequestBody ePace: EPace): ResponseEntity<Boolean> {
        val res = ePaceService.add(ePace)
        return ResponseEntity(res, HttpStatus.OK)
    }

    @DeleteMapping("/paces/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Boolean> {
        val res = ePaceService.delete(id)
        return ResponseEntity(res, HttpStatus.OK)
    }

    @PatchMapping("/paces")
    fun update(@RequestBody ePace: EPace): ResponseEntity<Boolean> {
        val res = ePaceService.update(ePace)
        return ResponseEntity(res, HttpStatus.OK)
    }
}
