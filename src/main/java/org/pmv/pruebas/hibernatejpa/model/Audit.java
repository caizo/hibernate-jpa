package org.pmv.pruebas.hibernatejpa.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Embeddable
public class Audit {

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @PrePersist
    public void prePersist() {

    }

    @PostPersist
    public void postPersist() {

    }

    @PreUpdate
    public void preUpdate() {

    }

    @PostUpdate
    public void postUpdate() {

    }

    @PreRemove
    public void preRemove() {

    }

    @PostRemove
    public void postRemove() {

    }
}
