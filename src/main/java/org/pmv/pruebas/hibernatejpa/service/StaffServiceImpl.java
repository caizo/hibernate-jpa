package org.pmv.pruebas.hibernatejpa.service;

import jakarta.persistence.EntityManager;
import org.pmv.pruebas.hibernatejpa.repository.StaffDao;
import org.pmv.pruebas.hibernatejpa.repository.StaffDaoImpl;

public class StaffServiceImpl implements StaffService {
    private final EntityManager entityManager;
    private final StaffDao staffDao;

    public StaffServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.staffDao = new StaffDaoImpl(this.entityManager);
    }

}
