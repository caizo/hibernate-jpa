package org.pmv.pruebas.hibernatejpa.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class FilmCategoryPK implements Serializable {

    private Long filmId;

    private Long categoryId;
}
