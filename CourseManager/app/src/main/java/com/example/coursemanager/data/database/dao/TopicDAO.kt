package com.example.coursemanager.data.database.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coursemanager.data.database.entity.Topic

interface TopicDAO {

    // Insertar un tema

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertTopic(topic: Topic)

    // Seleccionar todos los topics

    @Query("SELECT * FROM Topic WHERE codeCurse = :codeCourse")
    suspend fun selectTopic(codeCourse : String): MutableList<Topic>
}