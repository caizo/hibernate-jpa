package org.pmv.pruebas.hibernatejpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "film", schema = "sakila")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", nullable = false)
    private Long filmId;

    @Column(name = "title", nullable = false, length = 128)
    private String title;

    @Column(name = "description", length = -1)
    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "language_id", nullable = false)
    private Integer languageId;

    @Column(name = "original_language_id")
    private Integer originalLanguageId;

    @Column(name = "rental_duration", nullable = false)
    private Integer rentalDuration;

    @Column(name = "rental_rate", nullable = false, precision = 2)
    private BigDecimal rentalRate;

    @Column(name = "length")
    private Integer length;

    @Column(name = "replacement_cost", nullable = false, precision = 2)
    private BigDecimal replacementCost;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "special_features")
    private String specialFeatures;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

}
