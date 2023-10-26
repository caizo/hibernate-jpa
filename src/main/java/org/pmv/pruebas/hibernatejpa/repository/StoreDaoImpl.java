package org.pmv.pruebas.hibernatejpa.repository;

import jakarta.persistence.EntityManager;
import org.pmv.pruebas.hibernatejpa.model.Store;

public class StoreDaoImpl extends GenericDaoJpa<Store, Long> implements StoreDao {
    private final EntityManager entityManager;

    public StoreDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
