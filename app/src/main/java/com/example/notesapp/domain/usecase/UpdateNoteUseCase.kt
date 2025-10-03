package com.example.notesapp.domain.usecase

import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.repository.NoteRepository

class UpdateNoteUseCase(private val noteRepository: NoteRepository)  {
    suspend operator fun invoke(note: Note) {
        noteRepository.updateNote(note)
    }
}