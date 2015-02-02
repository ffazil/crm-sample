package com.tracebucket.partner.domain;

import com.tracebucket.infrastructure.ddd.annotation.ValueObject;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;

import javax.persistence.*;

/**
 * Created by ffl on 22-01-2015.
 * This is Organization in the partner bounded context.
 */
@ValueObject
@Embeddable
public class Owner {

    /*@Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "aggregateId", column = @Column(name = "clientId", nullable = false))})
    private AggregateId aggregateId;*/

    @Column(name = "NAME", /*nullable = false, */unique = true)
    @Basic(fetch = FetchType.EAGER)
    private String name;

    public Owner() {
    }

    public Owner(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
