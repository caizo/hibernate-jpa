package org.pmv.pruebas.hibernatejpa.model;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;
import org.pmv.pruebas.hibernatejpa.util.JpaUtil;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActorTest {

    private static EntityManager em;
    @BeforeAll
    static void setUp() {
        em = JpaUtil.getEM();
    }


    @Test
    void getActorsTest() {
        List<Actor> actors = em.createQuery("select a from Actor a", Actor.class)
                .getResultList();
        assertFalse(actors.isEmpty());
    }

    @Test
    void getActorsCalledNick() {
        TypedQuery<Actor> query = em.createQuery("select a from Actor a where a.firstName=:firstName", Actor.class);
        query.setParameter("firstName", "NICK");
        List<Actor> nicks = query.getResultList();
        assertEquals(3, nicks.size());
    }


    @Test
    void getActorsUpdatedOnYear() {
        LocalDateTime updateDate = LocalDateTime.of(2006, 1, 1, 0, 0);
        TypedQuery<Actor> query = em.createQuery("select a from Actor a where a.lastUpdate > :updateDate", Actor.class);
        query.setParameter("updateDate", updateDate);
        List<Actor> resultList = query.getResultList();
        assertFalse(resultList.isEmpty());
        resultList.forEach(System.out::println);

    }

    @AfterAll
    static void tearDown() {
        em.clear();
        em.close();
    }
}