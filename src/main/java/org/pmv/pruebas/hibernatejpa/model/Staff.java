package org.pmv.pruebas.hibernatejpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id", nullable = false)
    private Long staffId;
    
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;
    
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;
    
    @Column(name = "address_id", nullable = false)
    private Long addressId;
    
    @Column(name = "picture")
    private byte[] picture;
    
    @Column(name = "email", length = 50)
    private String email;
    
    @Column(name = "store_id", nullable = false)
    private Long storeId;
    
    @Column(name = "active", nullable = false)
    private byte active;
    
    @Column(name = "username", nullable = false, length = 16)
    private String username;
    
    @Column(name = "password", length = 40)
    private String password;
    
    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

}
