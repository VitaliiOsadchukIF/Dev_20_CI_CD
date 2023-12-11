package com.example.Dev_19_REST_API.controller;

import com.example.Dev_19_REST_API.entity.Note;

public interface BaseController {

    Object getAllNotes();

    Object getNoteBtId(Long id);

    Object createNote(Note note);

    Object editNoteById(Long id, Note note);

    Object deleteNoteById(Long id);
}
