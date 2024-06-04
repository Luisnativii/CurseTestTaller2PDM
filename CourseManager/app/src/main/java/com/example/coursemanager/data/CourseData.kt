package com.example.coursemanager.data

import androidx.compose.runtime.mutableStateListOf
import com.example.coursemanager.data.database.entity.Course
import com.example.coursemanager.data.database.entity.Topic

val curseList = mutableStateListOf<Course>(

    Course(
        code = "CSE1101",
        title = "Introduction to Computer Science",
        description = "This course is an introduction to the fundamental concepts of computer science. Topics include algorithms, data structures, programming languages, software engineering, and computer organization.",
        category = "Computer Science"
    ),
    Course(
        code = "CSE1102",
        title = "Programming I",
        description = "This course is an introduction to the fundamental concepts of software engineering. Topics include software development, software testing, software maintenance, and software project management.",
        category = "Computer Science"
    ),
    Course(
        code = "CSE1103",
        title = "Calculo I",
        description = "This course is an introduction to the fundamental concepts of software engineering. Topics include software development, software testing, software maintenance, and software project management.",
        category = "Mathematics"
    ),
)

val topicList = mutableStateListOf<Topic>(

    Topic(
        title = "Tema 1"

    ),
    Topic(
        title = "Tema 2"

    ),
    Topic(
        title = "Tema 3"

    ),


)
