package com.example.Dev_19_REST_API.service;

import com.example.Dev_19_REST_API.entity.Note;

public interface BaseService {

    Object getAll();

    Object getById(Long id);

    Object create(Note note);

    Object update(Note note);

    Object deleteById(Long id);
}
