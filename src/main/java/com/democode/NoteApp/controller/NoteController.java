package com.democode.NoteApp.controller;

import com.democode.NoteApp.entity.Note;
import com.democode.NoteApp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public Note createNote(@RequestBody String content , @AuthenticationPrincipal UserDetails userDetails ) //this is how get user details who user is login in to the application using spring security
    {
        String username = userDetails.getUsername();
        System.out.println("USER DETAILS: " + username);
        return noteService.CreateNoteForUser(username,content);

    }

    @GetMapping
    public List<Note> getAllNotes(@AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        System.out.println("USER DETAILS: " + username);
        return noteService.getNoteForUser(username);
    }

    @PutMapping("/{noteId}")
    public Note updateNote(@PathVariable Long id,@RequestBody String updateContent, @AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        System.out.println("USER DETAILS: " + username);
        return noteService.updateNoteForUser(id,updateContent,username);
    }

    @DeleteMapping("/{noteId}")
    public void deleteNote(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        System.out.println("USER DETAILS: " + username);
        noteService.DeleteNoteForUser(id,username);
    }


}
