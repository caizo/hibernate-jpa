package org.pmv.pruebas.hibernatejpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "rental", schema = "sakila")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id", nullable = false)
    private Long rentalId;
    
    @Column(name = "rental_date", nullable = false)
    private LocalDateTime rentalDate;
    
    @Column(name = "inventory_id", nullable = false)
    private Long inventoryId;
    
    @Column(name = "customer_id", nullable = false)
    private Long customerId;
    
    @Column(name = "return_date")
    private Timestamp returnDate;
    
    @Column(name = "staff_id", nullable = false)
    private Long staffId;
    
    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    @OneToMany(mappedBy = "rentalId")
    private Collection<Payment> paymentsByRentalId;

}
