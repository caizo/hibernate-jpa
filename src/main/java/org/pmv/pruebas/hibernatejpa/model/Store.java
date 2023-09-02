package org.pmv.pruebas.hibernatejpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Collection;

@Getter
@Setter
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id", nullable = false)
    private Long storeId;
    
    @Column(name = "manager_staff_id", nullable = false)
    private Long managerStaffId;

    @OneToOne(fetch = FetchType.LAZY)
    private Address addressId;
    
    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    @OneToMany(mappedBy = "storeId", fetch = FetchType.LAZY)
    private Collection<Staff> staffByStoreId;

}
