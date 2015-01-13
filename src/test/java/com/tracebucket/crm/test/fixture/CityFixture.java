package com.tracebucket.crm.test.fixture;

import com.tracebucket.common.domain.City;
import com.tracebucket.crm.test.builder.CityBuilder;

import java.util.Date;

/**
 * Created by sadath on 24-Nov-14.
 */
public class CityFixture {
    public static City standardCity() {
        City city = CityBuilder.aCityBuilder()
                .withName("City 1 " + new Date().getTime())
                .withImage("image")
/*                .withState(StateFixture.standardState())
                .withCountry(CountryFixture.standardCountry())
                .withTimezone(TimezoneFixture.standardTimezone())*/
                .build();
        return city;
    }

    public static City standardCity2() {
        City city = CityBuilder.aCityBuilder()
                .withName("City 2 " + new Date().getTime())
                .withImage("image")
/*                .withState(StateFixture.standardState())
                .withCountry(CountryFixture.standardCountry())
                .withTimezone(TimezoneFixture.standardTimezone())*/
                .build();
        return city;
    }
}
