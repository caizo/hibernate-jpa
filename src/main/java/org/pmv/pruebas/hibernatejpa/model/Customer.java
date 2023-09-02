package org.pmv.pruebas.hibernatejpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "customer", schema = "sakila")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @OneToMany
    private List<Store> storeId;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "address_id", nullable = false)
    private Long addressId;

    @Column(name = "active", nullable = false)
    private byte active;

    @Column(name = "create_date", nullable = false)
    private Timestamp createDate;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

}
