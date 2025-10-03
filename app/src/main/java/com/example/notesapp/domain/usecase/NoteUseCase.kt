package com.example.notesapp.domain.usecase

data class NoteUseCase(
    val getNotesUseCase: GetNoteUseCase,
    val updateNoteUseCase: UpdateNoteUseCase,
    val addNoteUseCase: AddNoteUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase
)
