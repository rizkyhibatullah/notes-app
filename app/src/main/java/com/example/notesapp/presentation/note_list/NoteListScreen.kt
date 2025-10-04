package com.example.notesapp.presentation.note_list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.notesapp.presentation.components.NoteItem

@Composable
fun NoteListScreen(
    viewModel: NoteListViewModel = hiltViewModel(),
    onAddNote: () -> Unit
) {
    val notes by viewModel.notes.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddNote) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add note")
            }
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(notes) { note ->
                NoteItem(note = note, onDeleteClick = { viewModel.deleteNote(note) })
            }
        }
    }
}