package com.example.notesapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notesapp.domain.model.Note

@Entity(tableName = "notes")
data class NoteEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String,
    val content: String,
    val timestamp: Long
)

fun NoteEntity.toDomain(): Note = Note(id, title, content, timestamp)
fun Note.toEntity(): NoteEntity = NoteEntity(id, title, content, timestamp)