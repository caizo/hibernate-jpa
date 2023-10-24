package org.pmv.pruebas.hibernatejpa.model;


import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.pmv.pruebas.hibernatejpa.service.ActorService;
import org.pmv.pruebas.hibernatejpa.service.ActorServiceImpl;
import org.pmv.pruebas.hibernatejpa.util.JpaUtil;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActorTest {

    private static final EntityManager entityManager = JpaUtil.getEntityManager();
    private final ActorService actorService = new ActorServiceImpl(entityManager);

    @Test
    void getAllTest() {
        List<Actor> actors = actorService.getAll();
        assertEquals(206, actors.size());
    }

    @Test
    void getByFirstNameTest() {
        assertEquals(3, this.actorService.getByFirstName("NICK").size());
    }

    @Test
    void getById() {
        Actor actor = actorService.findById(1L).orElseThrow();
        assertEquals("PENELOPE", actor.getFirstName());
        assertEquals("GUINESS", actor.getLastName());
    }

    @Test
    void getByLastUpdateTest() {
        LocalDateTime lastUpdate = LocalDateTime.of(2023, 10, 22, 22, 0);
        List<Actor> actors = actorService.getByLastUpdate(lastUpdate);
        assertEquals(4, actors.size());
    }

    @AfterAll
    static void tearDown() {
        entityManager.clear();
        entityManager.close();
    }

}