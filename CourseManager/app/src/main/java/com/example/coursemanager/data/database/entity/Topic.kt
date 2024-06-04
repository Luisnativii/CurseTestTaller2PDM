package com.example.coursemanager.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "Topic",
    foreignKeys = arrayOf(ForeignKey(
        entity = Course::class,
        parentColumns = arrayOf("code"),
        childColumns = arrayOf("codeCurse"),
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )
    )
)

data class Topic(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Int = 0,

    @ColumnInfo(name = "title")
    val title: String = "",


    // esta va a ser nuestra FK -> Topic

    @ColumnInfo(name = "codeCurse", index = true)
    val codeCurse: String = "",

)
