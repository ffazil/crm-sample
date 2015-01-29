package com.tracebucket.infrastructure.ddd.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by sadath on 28-Jan-15.
 */
@MappedSuperclass
public abstract class BaseValueObject {

    @Column(name = "PASSIVE", nullable = false, columnDefinition = "boolean default false")
    private boolean passive;

    public boolean isPassive() {
        return passive;
    }

    public void setPassive(boolean passive) {
        this.passive = passive;
    }
}
