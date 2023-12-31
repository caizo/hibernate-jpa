package org.pmv.pruebas.hibernatejpa.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    private static final EntityManagerFactory emf = buildEMF();

    private static EntityManagerFactory buildEMF() {
        return Persistence.createEntityManagerFactory("default");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
