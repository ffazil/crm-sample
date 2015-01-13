package com.tracebucket.crm.test.builder;

import com.tracebucket.common.domain.City;
import com.tracebucket.common.domain.Country;
import com.tracebucket.common.domain.State;
import com.tracebucket.common.domain.Timezone;

/**
 * Created by sadath on 21-Nov-14.
 */
public class CityBuilder {
    private String name;
    private String image;
    private State state;
    private Country country;
    private Timezone timezone;

    private CityBuilder(){ }

    public static CityBuilder aCityBuilder(){
        return new CityBuilder();
    }

    public CityBuilder withName(String name){
        this.name = name;
        return this;
    }

    public CityBuilder withImage(String image){
        this.image = image;
        return this;
    }

    public CityBuilder withState(State state){
        this.state = state;
        return this;
    }

    public CityBuilder withCountry(Country country){
        this.country = country;
        return this;
    }

    public CityBuilder withTimezone(Timezone timezone){
        this.timezone = timezone;
        return this;
    }

    public City build(){
        City city = new City();
        city.setName(name);
        city.setImage(image);
        city.setCountry(country);
        city.setState(state);
        city.setTimezone(timezone);
        return city;
    }
}
