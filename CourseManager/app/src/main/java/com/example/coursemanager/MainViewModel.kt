package com.example.coursemanager

import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coursemanager.data.database.MyApplication
import com.example.coursemanager.data.database.entity.Course
import com.example.coursemanager.data.database.entity.Topic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val db = MyApplication.database

    // insertar nuevo curso

    fun insertCourse(course: Course, topicList: MutableList<Topic>) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // insertar curso
                db.courseDAO().insertCourse(course)
                // insertadno una lista de temas
                for (topic in topicList) {
                    db.topicDAO().insertTopic(topic)
                }
            }
            catch (e: Exception) {

                when (e) {
                    is SQLiteConstraintException -> {
                        Log.i("MainViewModel", "Error inserting course")
                        // handle SQLiteConstraintException
                    }
                    else -> {
                        Log.i("MainViewModel", "Error inserting course")
                        // handle other exceptions
                    }
                }

            }

        }


    }

}