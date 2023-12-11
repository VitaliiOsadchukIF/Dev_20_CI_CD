package com.example.Dev_19_REST_API.repository;

import com.example.Dev_19_REST_API.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {

}
