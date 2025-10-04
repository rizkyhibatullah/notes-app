package com.example.notesapp.presentation.note_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.usecase.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val noteUseCase: NoteUseCase
) : ViewModel() {
    val notes = noteUseCase.getNotesUseCase()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            noteUseCase.deleteNoteUseCase(note)
        }
    }
}