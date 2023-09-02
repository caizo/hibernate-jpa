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
@Table(name = "inventory", schema = "sakila")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id", nullable = false)
    private Long inventoryId;

    @Column(name = "film_id", nullable = false)
    private Long filmId;

    @Column(name = "store_id", nullable = false)
    private Long storeId;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

}
