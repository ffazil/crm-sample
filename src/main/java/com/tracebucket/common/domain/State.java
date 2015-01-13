package com.tracebucket.common.domain;

import com.tracebucket.infrastructure.ddd.domain.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ffl on 20-11-2014.
 */
@Entity
@Table(name = "STATE")
public class State extends BaseEntity {

    @Column(name = "NAME", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private String name;

    @Column(name = "FLAG")
    @Basic(fetch = FetchType.EAGER)
    private String flag;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST})
    @JoinColumn(name = "COUNTRY__ID")
    private Country country;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "state", cascade = CascadeType.ALL)
    private Set<City> cities = new HashSet<City>(0);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }
}
