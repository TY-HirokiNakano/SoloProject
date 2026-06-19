package com.example.demo.repository

import com.example.demo.db.EPace

interface EPaceRepository {
    fun list(): List<EPace>
    fun get(id: Int): EPace?
    fun add(ePace: EPace): Boolean
    fun delete(id: Int): Boolean
    fun update(ePace: EPace): Boolean?
}