package com.tracebucket.organization.domain;

import com.tracebucket.infrastructure.ddd.domain.BaseEntity;

import javax.persistence.*;

/**
 * Created by ffl on 15-04-2014.
 */
@Entity
@Table(name = "BUSINESS_LINE")
public class BusinessLine extends BaseEntity {

    @Column(name = "NAME", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private String name;

    @Column(name = "DESCRIPTION")
    @Basic(fetch = FetchType.EAGER)
    private String description;

    public BusinessLine() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
