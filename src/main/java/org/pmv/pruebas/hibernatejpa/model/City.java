package org.pmv.pruebas.hibernatejpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "city", schema = "sakila")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false)
    private Long cityId;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @OneToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country countryId;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

}
