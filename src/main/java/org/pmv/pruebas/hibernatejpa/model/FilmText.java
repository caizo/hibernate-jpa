package org.pmv.pruebas.hibernatejpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "film_text")
public class FilmText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", nullable = false)
    private Long filmId;
    
    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "description", nullable = true)
    private String description;


}
