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
    
    @Column(name = "address_id", nullable = false)
    private Long addressId;
    
    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    @OneToMany(mappedBy = "storeId")
    private Collection<Staff> staffByStoreId;

    @ManyToOne
    @JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id", nullable = false,
            insertable = false, updatable = false)
    private Staff staffByManagerStaffId;


}
