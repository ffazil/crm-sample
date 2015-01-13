package com.tracebucket.crm.test.builder;

import com.tracebucket.common.domain.City;
import com.tracebucket.common.domain.Country;
import com.tracebucket.common.domain.State;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sadath on 24-Nov-14.
 */
public class StateBuilder {
    private String name;
    private String flag;
    private Country country;
    private Set<City> cities = new HashSet<City>(0);

    private StateBuilder(){ }

    public static StateBuilder aStateBuilder(){
        return new StateBuilder();
    }

    public StateBuilder withName(String name){
        this.name = name;
        return this;
    }

    public StateBuilder withFlag(String flag){
        this.flag = flag;
        return this;
    }

    public StateBuilder withCountry(Country country){
        this.country = country;
        return this;
    }

    public StateBuilder withCities(Set<City> cities){
        this.cities = cities;
        return this;
    }

    public State build(){
        State state = new State();
        state.setName(name);
        state.setFlag(flag);
        state.setCountry(country);
        state.setCities(cities);
        return state;
    }
}
