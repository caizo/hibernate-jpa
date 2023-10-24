package org.pmv.pruebas.hibernatejpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.pmv.pruebas.hibernatejpa.model.Film;

import java.util.List;

public class FilmDaoImpl extends GenericDaoJpa<Film,Long> implements FilmDao {
    private final EntityManager entityManager;

    public FilmDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Film> getAll() {
        String query = "select f from Film f";
        TypedQuery<Film> typedQuery = this.entityManager.createQuery(query, Film.class);
        return typedQuery.getResultList();
    }
}
