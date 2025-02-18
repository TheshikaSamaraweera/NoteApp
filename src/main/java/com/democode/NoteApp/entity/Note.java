package com.democode.NoteApp.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String content;

    private String ownerUsername;

}
