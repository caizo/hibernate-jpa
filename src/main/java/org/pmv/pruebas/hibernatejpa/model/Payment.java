package org.pmv.pruebas.hibernatejpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "payment", schema = "sakila")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false)
    private Long paymentId;
    
    @Column(name = "customer_id", nullable = false)
    private Long customerId;
    
    @Column(name = "staff_id", nullable = false)
    private Long staffId;
    
    @Column(name = "rental_id")
    private Integer rentalId;
    
    @Column(name = "amount", nullable = false, precision = 2)
    private BigDecimal amount;
    
    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;
    
    @Column(name = "last_update")
    private LocalDate lastUpdate;

}
