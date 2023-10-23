package org.pmv.pruebas.hibernatejpa.repository;

import jakarta.persistence.EntityManager;
import org.pmv.pruebas.hibernatejpa.util.JpaUtil;

import java.io.Serializable;

public abstract class GenericDaoJpa<E, K extends Serializable> implements GenericDao<E, K> {


    protected EntityManager entityManager = JpaUtil.getEntityManager();

    @Override
    public E saveOrUpdate(E entity, K primaryKey) {
        if (primaryKey == null) {
            this.entityManager.persist(entity);
        } else {
            this.entityManager.merge(entity);
        }

        return entity;
    }

}
