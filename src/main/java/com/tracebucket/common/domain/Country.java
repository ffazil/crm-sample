package com.tracebucket.common.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ffl on 20-11-2014.
 */
@Entity
@Table(name = "COUNTRY")
public class Country extends BaseEntity {

    @Column(name = "NAME", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private String name;

    @Column(name = "ABBREVIATION_2")
    @Basic(fetch = FetchType.EAGER)
    private String abbreviation_2;

    @Column(name = "ABBREVIATION_3")
    @Basic(fetch = FetchType.EAGER)
    private String abbreviation_3;

    @Column(name = "IDD")
    @Basic(fetch = FetchType.EAGER)
    private String idd;

    @Column(name = "FLAG")
    @Basic(fetch = FetchType.EAGER)
    private String flag;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country", cascade = CascadeType.ALL)
    private Set<State> states = new HashSet<State>(0);

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country", cascade = CascadeType.ALL)
    private Set<City> cities = new HashSet<City>(0);

/*    @ElementCollection
    @CollectionTable(name = "COUNTRY_CURRENCY", joinColumns = @JoinColumn(name = "COUNTRY__ID", referencedColumnName = "ID"))
    @MapKeyJoinColumn(name = "CURRENCY__ID", referencedColumnName = "ID")
    @Column(name="CURRENCY_TYPE")
    private Map<Currency, CurrencyType> currencies = new HashMap<Currency, CurrencyType>(0);*/

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "COUNTRY__ID", referencedColumnName = "ID")
    private Set<CountryCurrency> currencies = new HashSet<CountryCurrency>(0);

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST})
    @JoinTable(name = "COUNTRY_TIMEZONE", joinColumns = @JoinColumn(name = "COUNTRY__ID", referencedColumnName = "ID"),
               inverseJoinColumns = @JoinColumn(name = "TIMEZONE__ID", referencedColumnName = "ID"))
    private Set<Timezone> timezones = new HashSet<Timezone>(0);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation_2() {
        return abbreviation_2;
    }

    public void setAbbreviation_2(String abbreviation_2) {
        this.abbreviation_2 = abbreviation_2;
    }

    public String getAbbreviation_3() {
        return abbreviation_3;
    }

    public void setAbbreviation_3(String abbreviation_3) {
        this.abbreviation_3 = abbreviation_3;
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Set<State> getStates() {
        return states;
    }

    public void setStates(Set<State> states) {
        this.states = states;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

/*    public Map<Currency, CurrencyType> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Map<Currency, CurrencyType> currencies) {
        this.currencies = currencies;
    }*/

    public Set<Timezone> getTimezones() {
        return timezones;
    }

    public void setTimezones(Set<Timezone> timezones) {
        this.timezones = timezones;
    }

    public Set<CountryCurrency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Set<CountryCurrency> currencies) {
        this.currencies = currencies;
    }
}
