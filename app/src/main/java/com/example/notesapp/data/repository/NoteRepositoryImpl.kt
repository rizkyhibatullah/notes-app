package com.example.notesapp.data.repository

import com.example.notesapp.data.local.NoteDao
import com.example.notesapp.data.local.toDomain
import com.example.notesapp.data.local.toEntity
import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(private val dao: NoteDao) : NoteRepository  {
    override fun getNotes(): Flow<List<Note>> =
        dao.getNotes().map { list -> list.map { it.toDomain() } }♦

    override suspend fun updateNote(note: Note) = dao.updateNote(note.toEntity())
    override suspend fun insertNote(note: Note) = dao.insertNote(note.toEntity())
    override suspend fun deleteNote(note: Note) = dao.deleteNote(note.toEntity())

}