package org.pmv.pruebas.hibernatejpa.model;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.pmv.pruebas.hibernatejpa.util.JpaUtil;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ActorTest {

    private static EntityManager em;

    @BeforeAll
    static void setUp() {
        em = JpaUtil.getEntityManager();
    }


    @Test
    void getAllTest() {
        List<Actor> actors = em.createQuery("select a from Actor a", Actor.class)
                .getResultList();
        assertFalse(actors.isEmpty());
    }

    @Test
    void getByFirstNameTest() {
        String query = "select a from Actor a where a.firstName=:firstName";

        TypedQuery<Actor> tQuery = em.createQuery(query, Actor.class);

        tQuery.setParameter("firstName", "NICK");

        List<Actor> actors = tQuery.getResultList();

        assertEquals(3, actors.size());
    }

    @Test
    void getById() {

        Actor actor = em.find(Actor.class, 1L);

        assertEquals("PENELOPE", actor.getFirstName());
    }

    @Test
    void getByFirstNameTest2() {
        String query = "select a from Actor a where a.firstName=?1";

        TypedQuery<Actor> q = em.createQuery(query, Actor.class);

        q.setParameter(1, "NICK");

        List<Actor> actors2 = q.getResultList();

        assertEquals(3, actors2.size());
    }

    @Test
    void getByLastUpdateTest() {
        String query = "select a from Actor a where a.lastUpdate > :updateDate";

        TypedQuery<Actor> tQuery = em.createQuery(query, Actor.class);

        tQuery.setParameter("updateDate", LocalDateTime.of(2006, 1, 1, 0, 0));

        List<Actor> resultList = tQuery.getResultList();

        assertFalse(resultList.isEmpty());

        resultList.forEach(System.out::println);
    }

    @AfterAll
    static void tearDown() {
        em.clear();
        em.close();
    }
}