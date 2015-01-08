package com.tracebucket.infrastructure.ddd.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    private Long entityId;

    public Long getEntityId() {
        return entityId;
    }
}
