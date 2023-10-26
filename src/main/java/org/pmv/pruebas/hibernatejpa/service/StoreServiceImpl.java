package org.pmv.pruebas.hibernatejpa.service;

import jakarta.persistence.EntityManager;
import org.pmv.pruebas.hibernatejpa.dto.FilmDto;
import org.pmv.pruebas.hibernatejpa.model.Film;
import org.pmv.pruebas.hibernatejpa.repository.FilmDao;
import org.pmv.pruebas.hibernatejpa.repository.FilmDaoImpl;
import org.pmv.pruebas.hibernatejpa.repository.StoreDao;
import org.pmv.pruebas.hibernatejpa.repository.StoreDaoImpl;

import java.util.List;

public class StoreServiceImpl implements StoreService {
    private final EntityManager entityManager;
    private final StoreDao storeDao;

    public StoreServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.storeDao = new StoreDaoImpl(this.entityManager);
    }

}
