package org.pmv.pruebas.hibernatejpa.repository;

import jakarta.persistence.EntityManager;
import org.pmv.pruebas.hibernatejpa.model.Staff;

public class StaffDaoImpl extends GenericDaoJpa<Staff, Long> implements StaffDao {
    private final EntityManager entityManager;

    public StaffDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
