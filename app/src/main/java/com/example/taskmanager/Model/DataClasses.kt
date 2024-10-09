package com.example.taskmanager.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val dueDate: Long = System.currentTimeMillis(),
    val priority: String,
    val isCompleted: Boolean
)
