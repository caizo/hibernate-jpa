package org.pmv.pruebas.hibernatejpa.repository;

import org.pmv.pruebas.hibernatejpa.model.Actor;

import java.time.LocalDateTime;
import java.util.List;

public interface ActorDao {

    List<Actor> getByFirstName(String firstName);

    Actor saveOrUpdate(Actor actor);

    void delete(Long id);

    Actor findById(Long id);

    List<Actor> getByLastUpdate(LocalDateTime lastUpdate);

    List<Actor> getAll();
}
