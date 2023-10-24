package org.pmv.pruebas.hibernatejpa.service;

import org.pmv.pruebas.hibernatejpa.dto.FilmDto;
import org.pmv.pruebas.hibernatejpa.model.Film;

import java.util.List;

public interface FilmService {


    List<Film> getAll();

    List<Film> getFilmsLongerThanNMinutes(int minutes);

    List<FilmDto> getShortestFilms();

    List<FilmDto> getFilmsThatLastARangeOfMinutes(Integer range1, Integer range2);
}
