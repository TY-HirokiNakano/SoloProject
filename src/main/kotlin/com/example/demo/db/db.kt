package com.example.demo.db

import jakarta.persistence.Entity
import jakarta.persistence.Id

//repositoryが参照する際、データクラスのみを参照すれば済むように疎結合にしておく
@Entity
data class EPace(
    @Id
    val id: Int,
    val targetLower: Int,
    val targetUpper: Int,
    val ePaceLower: Int,
    val ePaceUpper: Int
)

//データとメソッドをobjectに閉じ込めて安全に管理する
object Db {
    //    privateにして、外からアクセスできないようにする
    private val ePaceList = mutableListOf(
        EPace(1, 100, 150, 100, 150),
        EPace(2, 200, 300, 200, 300),
        EPace(3, 300, 400, 300, 400),
    )

    fun list() = ePaceList
    fun get(id: Int) = ePaceList.find { it.id == id }
    fun add(ePace: EPace) = ePaceList.add(ePace)
    fun delete(id: Int) = ePaceList.removeIf { it.id == id }
    fun update(ePace: EPace) = ePaceList.find { it.id == ePace.id }
        ?.let { ePaceList.remove(it); ePaceList.add(ePace) }
}
