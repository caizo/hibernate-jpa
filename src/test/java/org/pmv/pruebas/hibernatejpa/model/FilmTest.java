package org.pmv.pruebas.hibernatejpa.model;


import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.pmv.pruebas.hibernatejpa.dto.FilmDto;
import org.pmv.pruebas.hibernatejpa.service.FilmService;
import org.pmv.pruebas.hibernatejpa.service.FilmServiceImpl;
import org.pmv.pruebas.hibernatejpa.util.JpaUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilmTest {

    private static final EntityManager entityManager = JpaUtil.getEntityManager();
    private final FilmService filmService = new FilmServiceImpl(entityManager);


    @Test
    void getAllFilmsTest() {
        List<Film> films = this.filmService.getAll();
        assertTrue(films.size() > 0);
        assertEquals(1000, films.size());
    }


    @Test
    void getFilmsLongerThanNMinutesTest() {
        List<Film> films = this.filmService.getFilmsLongerThanNMinutes(120);
        assertEquals(466, films.size());
    }

    @Test
    void getShortestFilmsTest() {
        List<FilmDto> shortestFilms = this.filmService.getShortestFilms();
        assertEquals(5, shortestFilms.size());
    }

    @AfterAll
    static void tearDown() {
        entityManager.clear();
        entityManager.close();
    }

}