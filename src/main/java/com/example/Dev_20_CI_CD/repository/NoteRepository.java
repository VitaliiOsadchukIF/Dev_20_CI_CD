package com.example.Dev_20_CI_CD.repository;

import com.example.Dev_20_CI_CD.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {

}
