package com.example.Dev_19_REST_API.controller;

import com.example.Dev_19_REST_API.entity.Note;
import com.example.Dev_19_REST_API.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/notes")
public class NoteController implements BaseController{

    private final NoteService service;


    @Override
    @GetMapping("/list")
    public ResponseEntity<List<Note>> getAllNotes() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteBtId(@PathVariable Long id) {
        return service.getById(id);
    }

    @Override
    @PostMapping("/add")
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return service.create(note);
    }

    @Override
    @PostMapping("/edit/{id}")
    public ResponseEntity editNoteById(@PathVariable Long id, @RequestBody Note note) {
        return service.update(note);
    }

    @Override
    @PostMapping("/delete/{id}")
    public ResponseEntity<Note> deleteNoteById(@PathVariable Long id) {
        return service.deleteById(id);
    }
}
