package com.democode.NoteApp.service;

import com.democode.NoteApp.entity.Note;
import com.democode.NoteApp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note CreateNoteForUser(String username,String content){
        Note note = new Note();
        note.setContent(content);
        note.setOwnerUsername(username);
        Note saveNote = noteRepository.save(note);
        return saveNote;
    }

    public Note updateNoteForUser(Long Id, String content ,String username){
        Note note = noteRepository.findById(Id).orElseThrow(() -> new RuntimeException("Note Not found"));
            note.setContent(content);
            Note updateNote = noteRepository.save(note);
            return updateNote;

    }

    public Void DeleteNoteForUser(Long noteId, String userName){
        Note note = noteRepository.findById(noteId).orElseThrow(() -> new RuntimeException("Note Not found"));
        if(!note.getOwnerUsername().equals(userName)){
            throw new RuntimeException("Unauthorized to delete this note");
        }
        noteRepository.deleteById(noteId);
        return null;
    }

    public List<Note> getNoteForUser(String username){
        List<Note> personalNote = noteRepository.findByOwnerUsername(username);
        return personalNote;
    }



}
