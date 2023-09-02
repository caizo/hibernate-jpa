package org.pmv.pruebas.hibernatejpa.util;

import jakarta.persistence.EntityManager;
import org.pmv.pruebas.hibernatejpa.model.Actor;

import java.util.List;

public class PruebasHibernate {


    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEM();

        List<Actor> actors = em.createQuery("select a from Actor a", Actor.class)
                .getResultList();


        actors.forEach(System.out::println);
    }
}
