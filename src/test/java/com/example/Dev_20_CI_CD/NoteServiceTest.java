package com.example.Dev_20_CI_CD;


import com.example.Dev_20_CI_CD.entity.Note;
import com.example.Dev_20_CI_CD.repository.NoteRepository;
import com.example.Dev_20_CI_CD.service.NoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class NoteServiceTest {

    @Mock
    private NoteRepository repository;

    @InjectMocks
    private NoteService noteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllNotes() {
        //Given
        List<Note> notes = Arrays.asList(
                new Note(1L, "Title 1", "Content 1", null),
                new Note(2L, "Title 2", "Content 2", null)
        );
        when(repository.findAll()).thenReturn(notes);

        //When
        ResponseEntity<List<Note>> response = noteService.getAll();

        //Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(notes, response.getBody());
    }

    @Test
    void testGetAllNotesNotFound() {
        //Given
        when(repository.findAll()).thenReturn(Arrays.asList());

        //When
        ResponseEntity<List<Note>> response = noteService.getAll();

        //Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testGetNoteById() {
        //Given
        Long noteId = 1L;
        Note note = new Note();
        when(repository.findById(noteId)).thenReturn(Optional.of(note));

        //When
        ResponseEntity<Note> response = noteService.getById(noteId);

        //Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(note, response.getBody());
    }

    @Test
    void testCreateNote() {
        //Given
        Note note = Note.builder()
                .id(1L)
                .title("Test Title")
                .content("Test Content")
                .createAt(null)
                .build();
        when(repository.save(any(Note.class))).thenReturn(note);

        //When
        ResponseEntity<Note> response = noteService.create(note);

        //Then
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(note, response.getBody());
    }

    @Test
    void testCreateNoteBadRequest() {

        //Given
        Note note = Note.builder().build();

        //When
        ResponseEntity<Note> response = noteService.create(note);

        //Then
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testUpdateNote() {

        //Given
        Note existingNote = Note.builder()
                .id(1L)
                .title("Existing Title")
                .content("Existing Content")
                .createAt(null)
                .build();

        when(repository.existsById(anyLong())).thenReturn(true);

        when(repository.save(any(Note.class))).thenReturn(existingNote);

        //When
        ResponseEntity<Note> response = noteService.update(existingNote);

        //Then
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(existingNote, response.getBody());
    }

    @Test
    void testUpdateNoteBadRequest() {

        //Given
        Note invalidNote = Note.builder().build();

        //When
        ResponseEntity<Note> response = noteService.update(invalidNote);

        //Then
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testDeleteNoteById() {

        //Given
        Long noteId = 1L;
        when(repository.existsById(noteId)).thenReturn(true);

        //When
        ResponseEntity<Note> response = noteService.deleteById(noteId);

        //Then
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void testDeleteNoteByIdNotFound() {

        //Given
        Long nonExistentNoteId = 999L;
        when(repository.existsById(nonExistentNoteId)).thenReturn(false);

        //When
        ResponseEntity<Note> response = noteService.deleteById(nonExistentNoteId);

        //Then
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
    }

}



