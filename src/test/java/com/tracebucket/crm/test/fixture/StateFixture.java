package com.tracebucket.crm.test.fixture;

import com.tracebucket.common.domain.City;
import com.tracebucket.common.domain.State;
import com.tracebucket.crm.test.builder.StateBuilder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sadath on 24-Nov-14.
 */
public class StateFixture {
    public static State standardState() {
        Set<City> cities = new HashSet<City>();
        cities.add(CityFixture.standardCity());
        cities.add(CityFixture.standardCity2());
        State state = StateBuilder.aStateBuilder()
                .withName("State 1")
                .withFlag("FLAG " + new Date().getTime())
                /*.withCountry(CountryFixture.standardCountry())
                .withCities(cities)*/
                .build();
        return state;
    }

    public static State standardState2() {
        Set<City> cities = new HashSet<City>();
        cities.add(CityFixture.standardCity());
        cities.add(CityFixture.standardCity2());
        State state = StateBuilder.aStateBuilder()
                .withName("State 2")
                .withFlag("FLAG " + new Date().getTime())
                /*.withCountry(CountryFixture.standardCountry())
                .withCities(cities)*/
                .build();
        return state;
    }

}
