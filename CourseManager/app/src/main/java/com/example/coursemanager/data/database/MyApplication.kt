package com.example.coursemanager.data.database

import android.app.Application
import androidx.room.Room

class MyApplication : Application() {

    companion object {
        lateinit var database: CoursesDatabase
    }

    override fun onCreate() {
        super.onCreate()


        database = Room.databaseBuilder(
            this, CoursesDatabase::class.java,
            "courses-db").build()
    }

}