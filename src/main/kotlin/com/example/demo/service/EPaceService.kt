package com.example.demo.service

import com.example.demo.db.EPace

interface EPaceService {
    fun list(): List<EPace>
    fun get(id: Int): EPace?
    fun add(ePace: EPace): Boolean
    fun delete(id: Int): Boolean
    fun update(ePace: EPace): Boolean?
}