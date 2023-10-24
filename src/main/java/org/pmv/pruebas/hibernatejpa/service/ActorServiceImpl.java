package org.pmv.pruebas.hibernatejpa.service;

import jakarta.persistence.EntityManager;
import org.pmv.pruebas.hibernatejpa.dto.ActorDto;
import org.pmv.pruebas.hibernatejpa.model.Actor;
import org.pmv.pruebas.hibernatejpa.repository.ActorDao;
import org.pmv.pruebas.hibernatejpa.repository.ActorDaoImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ActorServiceImpl implements ActorService {

    private final EntityManager entityManager;
    private final ActorDao actorDao;

    public ActorServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.actorDao = new ActorDaoImpl(this.entityManager);
    }

    @Override
    public List<Actor> getByFirstName(String firstName) {
        return actorDao.getByFirstName(firstName);
    }

    @Override
    public Optional<Actor> findById(Long id) {
        return Optional.ofNullable(this.actorDao.findById(id));
    }

    @Override
    public List<Actor> getByLastUpdate(LocalDateTime lastUpdate) {
        return this.actorDao.getByLastUpdate(lastUpdate);
    }

    @Override
    public List<Actor> getAll() {
        return this.actorDao.getAll();
    }

    @Override
    public Actor saveOrUpdate(Actor actor) {
        try {
            entityManager.getTransaction().begin();
            actor = this.actorDao.saveOrUpdate(actor);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return actor;
    }

    @Override
    public void delete(Long id) {
        try {
            entityManager.getTransaction().begin();
            this.actorDao.delete(id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Object[]> getActorsFullName() {
        return this.actorDao.getActorsFullName();
    }

    @Override
    public List<ActorDto> getActorsFullNameDto() {
        return this.actorDao.getActorsFullNameDto();
    }
}
