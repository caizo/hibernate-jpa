package org.pmv.pruebas.hibernatejpa.model;


import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.pmv.pruebas.hibernatejpa.service.FilmService;
import org.pmv.pruebas.hibernatejpa.service.FilmServiceImpl;
import org.pmv.pruebas.hibernatejpa.util.JpaUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FilmTest {

    private static final EntityManager entityManager = JpaUtil.getEntityManager();
    private final FilmService filmService = new FilmServiceImpl(entityManager);


    @Test
    void getAllFilms() {
        List<Film> films = this.filmService.getAll();
        assertTrue(films.size() > 0);
        assertEquals(1000, films.size());
    }

    @AfterAll
    static void tearDown() {
        entityManager.clear();
        entityManager.close();
    }

}