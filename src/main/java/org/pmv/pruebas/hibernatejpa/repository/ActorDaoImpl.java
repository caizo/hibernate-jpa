package org.pmv.pruebas.hibernatejpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.pmv.pruebas.hibernatejpa.model.Actor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

public class ActorDaoImpl extends GenericDaoJpa<Actor, Long> implements ActorDao {

    private final EntityManager entityManager;

    public ActorDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Actor> getByFirstName(String firstName) {
        String query = "select a from Actor a where a.firstName=:firstName";

        TypedQuery<Actor> tQuery = entityManager.createQuery(query, Actor.class);

        tQuery.setParameter("firstName", firstName);

        return tQuery.getResultList();

    }

    @Override
    public Actor saveOrUpdate(Actor actor) {
        return super.saveOrUpdate(actor, actor.getActorId());
    }

    @Override
    public void delete(Long id) {
        Actor actor = entityManager.find(Actor.class, id);
        if (actor != null) {
            entityManager.remove(actor);
        }
        throw new NoSuchElementException("Actor no encontrado");
    }

    @Override
    public Actor findById(Long id) {
        return entityManager.find(Actor.class, id);
    }

    @Override
    public List<Actor> getByLastUpdate(LocalDateTime lastUpdate) {
        String query = "select a from Actor a where a.lastUpdate = :updateDate";

        TypedQuery<Actor> tQuery = entityManager.createQuery(query, Actor.class);

        tQuery.setParameter("updateDate", lastUpdate);

        return tQuery.getResultList();
    }

    @Override
    public List<Actor> getAll() {
        return entityManager.createQuery("select a from Actor a", Actor.class)
                .getResultList();
    }

    @Override
    public List<Object[]> getActorsFullName() {
        return entityManager.createQuery("select a.firstName, a.lastName from Actor a", Object[].class)
                .getResultList();
    }

}
