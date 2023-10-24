package org.pmv.pruebas.hibernatejpa.repository;

import org.pmv.pruebas.hibernatejpa.model.Film;

import java.util.List;

public interface FilmDao {
    List<Film> getAll();
}
