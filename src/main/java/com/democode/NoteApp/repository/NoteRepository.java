package com.democode.NoteApp.repository;

import com.democode.NoteApp.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {

    List<Note> findByOwnerUsername(String ownerUsername);
}
