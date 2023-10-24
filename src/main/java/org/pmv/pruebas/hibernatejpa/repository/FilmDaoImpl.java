package org.pmv.pruebas.hibernatejpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.pmv.pruebas.hibernatejpa.dto.FilmDto;
import org.pmv.pruebas.hibernatejpa.model.Film;

import java.util.Arrays;
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

    @Override
    public List<Film> getFilmsLongerThanNMinutes(int minutes) {
        String query = "select f from Film f where f.length >= :minutes";
        TypedQuery<Film> typedQuery = this.entityManager.createQuery(query, Film.class);
        typedQuery.setParameter("minutes", minutes);
        return typedQuery.getResultList();
    }

    @Override
    public List<FilmDto> getShortestFilms() {
        TypedQuery<FilmDto> typedQuery =
                this.entityManager.createQuery("select new org.pmv.pruebas.hibernatejpa.dto.FilmDto(f.title,f.length) from Film f where f.length =(select min (fi.length) from Film fi) ", FilmDto.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<FilmDto> getFilmsThatLastARangeOfMinutes(Integer range1, Integer range2) {
        TypedQuery<FilmDto> typedQuery =
                this.entityManager.createQuery("select new org.pmv.pruebas.hibernatejpa.dto.FilmDto(f.title,f.length) from Film f where f.length in :duration", FilmDto.class);
        typedQuery.setParameter("duration", Arrays.asList(range1,range2));
        return typedQuery.getResultList();
    }
}
