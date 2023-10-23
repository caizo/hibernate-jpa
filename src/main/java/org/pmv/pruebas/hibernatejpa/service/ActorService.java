package org.pmv.pruebas.hibernatejpa.service;

import org.pmv.pruebas.hibernatejpa.model.Actor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ActorService {

    List<Actor> getByFirstName(String firstName);

    Optional<Actor> findById(Long id);

    List<Actor> getByLastUpdate(LocalDateTime lastUpdate);

    List<Actor> getAll();

    Actor saveOrUpdate(Actor actor);

    void delete(Long id);

}