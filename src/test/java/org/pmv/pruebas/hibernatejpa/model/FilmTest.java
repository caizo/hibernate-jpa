package org.pmv.pruebas.hibernatejpa.model;


import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.pmv.pruebas.hibernatejpa.dto.FilmDto;
import org.pmv.pruebas.hibernatejpa.service.FilmService;
import org.pmv.pruebas.hibernatejpa.service.FilmServiceImpl;
import org.pmv.pruebas.hibernatejpa.util.JpaUtilTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FilmTest {

    private static final EntityManager entityManager = JpaUtilTest.getEntityManager();
    private final FilmService filmService = new FilmServiceImpl(entityManager);


    @Test
    void getAllFilmsTest() {
        List<Film> films = this.filmService.getAll();
        assertTrue(films.size() > 0);
        assertEquals(1, films.size());
    }


    @Disabled
    void getFilmsLongerThanNMinutesTest() {
        List<Film> films = this.filmService.getFilmsLongerThanNMinutes(120);
        assertEquals(466, films.size());
    }

    @Disabled
    void getShortestFilmsTest() {
        List<FilmDto> shortestFilms = this.filmService.getShortestFilms();
        assertEquals(5, shortestFilms.size());
    }

    @Disabled
    void getFilmsThatLastARangeOfMinutes() {
        Integer range1 = 60;
        Integer range2 = 120;

        List<FilmDto> films =
                this.filmService.getFilmsThatLastARangeOfMinutes(range1, range2);
        assertEquals(17, films.size());
    }

    @AfterAll
    static void tearDown() {
        entityManager.clear();
        entityManager.close();
    }

}