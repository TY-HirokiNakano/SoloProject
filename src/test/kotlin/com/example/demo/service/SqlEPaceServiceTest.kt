package com.example.demo.service

import com.example.demo.db.EPace
import com.example.demo.repository.EPaceRepository
import com.example.demo.repository.SpyEPaceRepository
import com.example.demo.repository.repoCheck

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

fun main() {
//    println("1:" + SqlEPaceService(repoCheck).list())
//    println("2:" + SqlEPaceService(repoCheck).get(2))
//    println("3:" + SqlEPaceService(repoCheck).delete(2))
//    println("4:" + SqlEPaceService(repoCheck).add(EPace(5, 500, 600, 500, 600)))
//    println("5:" + SqlEPaceService(repoCheck).list())
//    println("6:" + SqlEPaceService(repoCheck).update(EPace(5, 1500, 1600, 500, 600)))
//    println("7:" + SqlEPaceService(repoCheck).list())

    val spy = SpyEPaceRepository()
    val service = SqlEPaceService(spy)

    service.list()
    println(spy.isListCalled)

    service.get(2)
    println(spy.idCalledByGet)
    println(spy.idCalledByGet == 2)

    service.add(EPace(5, 500, 600, 500, 600))
    println(spy.isAddCalled)
    println(spy.ePaceCalledByAdd)

    service.delete(2)
    println(spy.isDeleteCalled)
    println(spy.idCalledByDelete)

    service.update(EPace(5, 1500, 1600, 500, 600))
    println(spy.isUpdateCalled)
    println(spy.ePaceCalledByUpdate)
}