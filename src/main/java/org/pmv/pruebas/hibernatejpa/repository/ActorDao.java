package org.pmv.pruebas.hibernatejpa.repository;

import org.pmv.pruebas.hibernatejpa.dto.ActorDto;
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

    List<Object[]> getActorsFullName();

    List<ActorDto> getActorsFullNameDto();

    List<String> getActorsDistinctName();

    Long getNumberOfActorsWithDifferentName();

    List<ActorDto> getActorsWithSpecificTextInName(String text);

    List<ActorDto> getActorsByPosition(Long p1, Long p2);

    List<ActorDto> getActorsByIdDesc();
}
