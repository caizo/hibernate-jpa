package org.pmv.pruebas.hibernatejpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.pmv.pruebas.hibernatejpa.dto.ActorDto;
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

    @Override
    public List<ActorDto> getActorsFullNameDto() {
        return entityManager.createQuery("select new org.pmv.pruebas.hibernatejpa.dto.ActorDto(upper(concat(a.firstName,' ', a.lastName)),a.lastUpdate) from Actor a", ActorDto.class)
                .getResultList();
    }

    @Override
    public List<String> getActorsDistinctName() {
        return entityManager.createQuery("select distinct(a.firstName) from Actor a", String.class)
                .getResultList();

    }

    @Override
    public Long getNumberOfActorsWithDifferentName() {
        return entityManager.createQuery("select count(distinct(a.firstName)) from Actor a", Long.class)
                .getSingleResult();
    }

    @Override
    public List<ActorDto> getActorsWithSpecificTextInName(String text) {
        TypedQuery<ActorDto> typedQuery =
                entityManager.createQuery("select new org.pmv.pruebas.hibernatejpa.dto.ActorDto(concat(a.firstName,' ',a.lastName), a.lastUpdate) from Actor a where a.firstName like :text", ActorDto.class);
        typedQuery.setParameter("text", "%" + text + "%");
        return typedQuery.getResultList();
    }

    @Override
    public List<ActorDto> getActorsByPosition(Long p1, Long p2) {
        TypedQuery<ActorDto> typedQuery =
                entityManager.createQuery("select new org.pmv.pruebas.hibernatejpa.dto.ActorDto(concat(a.firstName,' ',a.lastName), a.lastUpdate) from Actor a where a.id between :p1 and :p2", ActorDto.class);
        typedQuery.setParameter("p1", p1);
        typedQuery.setParameter("p2", p2);

        return typedQuery.getResultList();
    }

    @Override
    public List<ActorDto> getActorsByIdDesc() {
        TypedQuery<ActorDto> typedQuery =
                entityManager.createQuery("select new org.pmv.pruebas.hibernatejpa.dto.ActorDto(concat(a.firstName,' ',a.lastName), a.lastUpdate) from Actor a order by a.id desc", ActorDto.class);
        return typedQuery.getResultList();
    }


}
