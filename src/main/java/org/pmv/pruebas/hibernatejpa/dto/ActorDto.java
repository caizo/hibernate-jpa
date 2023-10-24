package org.pmv.pruebas.hibernatejpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ActorDto {

    private String fullName;
    private LocalDateTime lastUpdate;

    public ActorDto(String fullName, LocalDateTime lastUpdate) {
        this.fullName = fullName;
        this.lastUpdate = lastUpdate;
    }
}
