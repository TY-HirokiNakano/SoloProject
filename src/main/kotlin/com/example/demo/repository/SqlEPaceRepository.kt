package com.example.demo.repository

import com.example.demo.db.EPace
import org.springframework.stereotype.Repository

//springに対して、EPaceRepositoryを実装したクラスを明示するため
@Repository
//JpaRepositoryを継承したEPaceJpaRepositoryというinterfaceを受け取りつつ、EPaceRepositoryを実装するイメージ
//処理は EPaceJpaRepositoryのメソッドを流用する
class SqlEPaceRepository(private val jpaRepository: EPaceJpaRepository) : EPaceRepository {
    override fun list(): List<EPace> {
//        return Db.list()
        return jpaRepository.findAll()
    }

    override fun get(id: Int): EPace? {
//        return Db.get(id)
        return jpaRepository.findById(id).orElse(null)
    }


    override fun add(ePace: EPace): Boolean {
//        return Db.add(ePace)
        return jpaRepository.save(ePace) != null
    }

    override fun delete(id: Int): Boolean {
//        return Db.delete(id)
        return jpaRepository.deleteById(id) != null
    }

    override fun update(ePace: EPace): Boolean? {
//        return Db.update(ePace)
        return jpaRepository.save(ePace) != null
    }
}