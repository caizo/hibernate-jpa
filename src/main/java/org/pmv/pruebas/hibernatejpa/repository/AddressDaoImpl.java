package org.pmv.pruebas.hibernatejpa.repository;

import jakarta.persistence.EntityManager;
import org.pmv.pruebas.hibernatejpa.model.Address;

public class AddressDaoImpl extends GenericDaoJpa<Address, Long> implements AddressDao {
    private final EntityManager entityManager;

    public AddressDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
