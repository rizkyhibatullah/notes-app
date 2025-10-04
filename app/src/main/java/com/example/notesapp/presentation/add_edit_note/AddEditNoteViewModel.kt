package com.example.notesapp.presentation.add_edit_note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.usecase.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val noteUseCase: NoteUseCase
) : ViewModel() {
    fun addNote(title: String, content: String) {
        viewModelScope.launch {
            val note = Note(
                title = title,
                content = content,
                timestamp = System.currentTimeMillis()
            )
            noteUseCase.addNoteUseCase(note)
        }

    }
}