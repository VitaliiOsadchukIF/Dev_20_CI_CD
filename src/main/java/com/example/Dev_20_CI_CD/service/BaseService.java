package com.example.Dev_20_CI_CD.service;

import com.example.Dev_20_CI_CD.entity.Note;

public interface BaseService {

    Object getAll();

    Object getById(Long id);

    Object create(Note note);

    Object update(Note note);

    Object deleteById(Long id);
}
