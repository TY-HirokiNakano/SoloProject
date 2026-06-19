package com.example.demo.service

import com.example.demo.db.EPace
import com.example.demo.repository.EPaceRepository
import org.springframework.stereotype.Service

@Service
class SqlEPaceService(private val ePaceRepository: EPaceRepository) : EPaceService {
    override fun list(): List<EPace> {
        return ePaceRepository.list()
    }

    override fun get(id: Int): EPace? {
        return ePaceRepository.get(id)
    }

    override fun add(ePace: EPace): Boolean {
        return ePaceRepository.add(ePace)
    }

    override fun delete(id: Int): Boolean {
        return ePaceRepository.delete(id)
    }

    override fun update(ePace: EPace): Boolean? {
        return ePaceRepository.update(ePace)
    }
}