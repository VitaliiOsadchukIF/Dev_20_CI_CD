package com.example.Dev_20_CI_CD.controller;

import com.example.Dev_20_CI_CD.entity.Note;

public interface BaseController {

    Object getAllNotes();

    Object getNoteBtId(Long id);

    Object createNote(Note note);

    Object editNoteById(Long id, Note note);

    Object deleteNoteById(Long id);
}
