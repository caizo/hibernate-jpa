package org.pmv.pruebas.hibernatejpa.model;


import org.junit.jupiter.api.Test;
import org.pmv.pruebas.hibernatejpa.repository.ActorDao;
import org.pmv.pruebas.hibernatejpa.repository.ActorDaoImpl;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActorTest {

    private ActorDao actorDao = new ActorDaoImpl();

    @Test
    void getAllTest() {
        List<Actor> actors = actorDao.getAll();
        assertEquals(206, actors.size());
    }

    @Test
    void getByFirstNameTest() {
        assertEquals(3, this.actorDao.getByFirstName("NICK").size());
    }

    @Test
    void getById() {
        Actor actor = actorDao.findById(1L);
        assertEquals("PENELOPE", actor.getFirstName());
        assertEquals("GUINESS", actor.getLastName());
    }


    @Test
    void getByLastUpdateTest() {
        LocalDateTime lastUpdate = LocalDateTime.of(2023, 10, 23, 0, 0);
        List<Actor> actors = this.actorDao.getByLastUpdate(lastUpdate);
        assertEquals(4, actors.size());

    }

}