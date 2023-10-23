package org.pmv.pruebas.hibernatejpa.repository;

import java.io.Serializable;

public interface GenericDao<E, K extends Serializable> {

    E saveOrUpdate(E entity, K primaryKey);

}