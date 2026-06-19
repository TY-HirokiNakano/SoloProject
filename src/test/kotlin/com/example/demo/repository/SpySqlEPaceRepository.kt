package com.example.demo.repository

import com.example.demo.db.EPace

//SqlEPaceServiceに渡すテストダブル
class SpyEPaceRepository : EPaceRepository {
    val ePaceList = mutableListOf<EPace>(
        EPace(1, 100, 150, 100, 150),
        EPace(2, 200, 300, 200, 300),
        EPace(3, 300, 400, 300, 400),
        EPace(4, 400, 500, 400, 500),
    )
    var isListCalled = false
    var isGetCalled = false
    var isAddCalled = false
    var isDeleteCalled = false
    var isUpdateCalled = false

    var idCalledByGet: Int? = null
    var ePaceCalledByAdd: EPace? = null
    var idCalledByDelete: Int? = null
    var ePaceCalledByUpdate: EPace? = null


    override fun list(): List<EPace> {
        isListCalled = true
        return ePaceList
    }

    override fun get(id: Int): EPace? {
        isGetCalled = true
        idCalledByGet = id
        return ePaceList.find { it.id == id }
    }

    override fun add(ePace: EPace): Boolean {
        isAddCalled = true
        ePaceCalledByAdd = ePace
        ePaceList.add(ePace)
        return true
    }

    override fun delete(id: Int): Boolean {
        isDeleteCalled = true
        idCalledByDelete = id
        ePaceList.removeIf { it.id == id }
        return true
    }

    override fun update(ePace: EPace): Boolean? {
        isUpdateCalled = true
        ePaceCalledByUpdate = ePace
        ePaceList.find { it.id == ePace.id }?.let { ePaceList.remove(it); ePaceList.add(ePace) }
        return null
    }
}

val repoCheckSpy = SpyEPaceRepository()