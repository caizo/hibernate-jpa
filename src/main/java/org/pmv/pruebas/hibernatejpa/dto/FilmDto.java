package org.pmv.pruebas.hibernatejpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class FilmDto {
    private String title;
    private Integer length;


    public FilmDto(String title, Integer length) {
        this.title = title;
        this.length = length;
    }
}
