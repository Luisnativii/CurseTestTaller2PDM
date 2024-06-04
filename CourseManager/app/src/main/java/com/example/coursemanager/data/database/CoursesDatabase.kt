package com.example.coursemanager.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coursemanager.data.database.dao.CourseDAO
import com.example.coursemanager.data.database.dao.TopicDAO
import com.example.coursemanager.data.database.entity.Course
import com.example.coursemanager.data.database.entity.Topic

@Database(

    entities = [Course::class, Topic::class],
    version = 1

)

abstract class CoursesDatabase : RoomDatabase(){
    abstract fun courseDAO() : CourseDAO
    abstract fun topicDAO() : TopicDAO

}