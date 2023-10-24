package org.pmv.pruebas.hibernatejpa.service;

import jakarta.persistence.EntityManager;
import org.pmv.pruebas.hibernatejpa.dto.FilmDto;
import org.pmv.pruebas.hibernatejpa.model.Film;
import org.pmv.pruebas.hibernatejpa.repository.FilmDao;
import org.pmv.pruebas.hibernatejpa.repository.FilmDaoImpl;

import java.util.List;

public class FilmServiceImpl implements FilmService {
    private final EntityManager entityManager;
    private final FilmDao filmDao;

    public FilmServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.filmDao = new FilmDaoImpl(this.entityManager);
    }

    @Override
    public List<Film> getAll() {
        return this.filmDao.getAll();
    }

    @Override
    public List<Film> getFilmsLongerThanNMinutes(int minutes) {
        return this.filmDao.getFilmsLongerThanNMinutes(minutes);
    }

    @Override
    public List<FilmDto> getShortestFilms() {
        return this.filmDao.getShortestFilms();
    }

    @Override
    public List<FilmDto> getFilmsThatLastARangeOfMinutes(Integer range1, Integer range2) {
        return this.filmDao.getFilmsThatLastARangeOfMinutes(range1, range2);
    }
}
