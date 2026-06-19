package com.example.demo.repository

import com.example.demo.db.EPace
import org.springframework.data.jpa.repository.JpaRepository

//entityと主キーの型を指定する
interface EPaceJpaRepository : JpaRepository<EPace, Int> {}
