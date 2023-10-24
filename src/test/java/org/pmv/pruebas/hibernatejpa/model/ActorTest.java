package org.pmv.pruebas.hibernatejpa.model;


import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.pmv.pruebas.hibernatejpa.dto.ActorDto;
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

    @Test
    void getActorsFullNameTest() {
        List<Object[]> actors = actorService.getActorsFullName();
        assertEquals(206, actors.size());

        Object[] first = actors.get(0);
        assertEquals(first[0],"PENELOPE");
        assertEquals(first[1],"GUINESS");

        Object[] last = actors.get(actors.size() - 1);
        assertEquals(last[0],"Al");
        assertEquals(last[1],"Pacino");

    }

    @Test
    void getActorsDtoTest() {
        List<ActorDto> dtos = actorService.getActorsFullNameDto();

        ActorDto first = dtos.get(0);
        assertEquals(first.getFullName(),"PENELOPE GUINESS");

        ActorDto last = dtos.get(dtos.size() - 1);
        assertEquals(last.getFullName(),"AL PACINO");

    }

    @Test
    void getActorsDistinctNameTest() {
        List<String> actors = this.actorService.getActorsDistinctName();
        assertEquals(129, actors.size());
    }

    @Test
    void getNumberOfActorsWithDifferentNameTest() {
        Long result = this.actorService.getNumberOfActorsWithDifferentName();
        assertEquals(129, result);
    }


    @Test
    void getActorsWithSpecificTextInNameTest() {
        String text = "RE";
        List<ActorDto> actors = this.actorService.getActorsWithSpecificTextInName(text);
        assertEquals(17, actors.size());
    }


    @Test
    void getActorsByPositionTest() {
        Long p1 = 1L;
        Long p2 = 5L;
        List<ActorDto> actors =  this.actorService.getActorsByPosition(p1, p2);
        assertEquals(5, actors.size());
    }

    @Test
    void getActorsByIdDescTest() {
        List<ActorDto> actors =  this.actorService.getActorsByIdDesc();

        assertEquals(206, actors.size());

        ActorDto first = actors.get(0);
        assertEquals("Al Pacino", first.getFullName());

        ActorDto last = actors.get(actors.size() - 1);
        assertEquals("PENELOPE GUINESS", last.getFullName());

    }

    @AfterAll
    static void tearDown() {
        entityManager.clear();
        entityManager.close();
    }

}