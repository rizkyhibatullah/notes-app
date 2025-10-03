package com.example.notesapp.domain.usecase

import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetNoteUseCase(private val noteRepository: NoteRepository)  {
    operator fun invoke () = noteRepository.getNotes()
}