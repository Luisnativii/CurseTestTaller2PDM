package com.example.coursemanager.data.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.coursemanager.data.database.entity.Course

interface CourseDAO {

    // Selcionar todos los cursos

    @Query("SELECT * FROM course")

    suspend fun getAllCourses() : MutableList<Course>

    // Seleccionar un curso por su código


    @Query("SELECT * FROM course WHERE code = :codeCurse")
    suspend fun getCourse(codeCurse: String) : Course


    // Insertar un curso

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertCourse(course: Course)

    // Actualizar un curso

    @Update
    suspend fun updateCourse(course: Course)


    // Eliminar un curso


    @Delete
    suspend fun deleteCourse(course: Course)


}