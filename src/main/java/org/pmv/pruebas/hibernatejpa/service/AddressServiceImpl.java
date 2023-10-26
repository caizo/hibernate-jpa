package org.pmv.pruebas.hibernatejpa.service;

import jakarta.persistence.EntityManager;
import org.pmv.pruebas.hibernatejpa.repository.AddressDao;
import org.pmv.pruebas.hibernatejpa.repository.AddressDaoImpl;
import org.pmv.pruebas.hibernatejpa.repository.StoreDao;
import org.pmv.pruebas.hibernatejpa.repository.StoreDaoImpl;

public class AddressServiceImpl implements AddressService {
    private final EntityManager entityManager;
    private final AddressDao addressDao;

    public AddressServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.addressDao = new AddressDaoImpl(this.entityManager);
    }

}
