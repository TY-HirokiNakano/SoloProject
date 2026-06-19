package com.example.demo.repository

import com.example.demo.db.EPace

//SqlEPaceServiceに渡すテストダブル
class FakeEPaceRepository : EPaceRepository {
    val ePaceList = mutableListOf<EPace>(
        EPace(1, 100, 150, 100, 150),
        EPace(2, 200, 300, 200, 300),
        EPace(3, 300, 400, 300, 400),
        EPace(4, 400, 500, 400, 500),
    )

    override fun list(): List<EPace> {
        return ePaceList
    }

    override fun get(id: Int): EPace? {
        return ePaceList.find { it.id == id }
    }

    override fun add(ePace: EPace): Boolean {
        ePaceList.add(ePace)
        return true
    }

    override fun delete(id: Int): Boolean {
        ePaceList.removeIf { it.id == id }
        return true
    }

    override fun update(ePace: EPace): Boolean? {
        ePaceList.find { it.id == ePace.id }?.let { ePaceList.remove(it); ePaceList.add(ePace) }
        return null
    }
}

val repoCheck = FakeEPaceRepository()