package com.tracebucket.crm.test.fixture;

import com.tracebucket.common.domain.*;
import com.tracebucket.crm.test.builder.CountryBuilder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sadath on 24-Nov-14.
 */
public class CountryFixture {
    public static Country standardCountry() {
        Set<City> cities = new HashSet<City>();
        cities.add(CityFixture.standardCity());
        cities.add(CityFixture.standardCity2());

        Set<State> states = new HashSet<State>();
        states.add(StateFixture.standardState());
        states.add(StateFixture.standardState2());

/*        Map<Currency, CurrencyType> currencies = new HashMap<Currency, CurrencyType>();
        currencies.put(CurrencyFixture.standardCurrency(), CurrencyType.DEFAULT);
        currencies.put(CurrencyFixture.standardCurrency2(), CurrencyType.OPTIONAL);*/

        Set<CountryCurrency> currencies = new HashSet<CountryCurrency>();
        currencies.add(CountryCurrencyFixture.standardCountryCurrency());
        currencies.add(CountryCurrencyFixture.standardCountryCurrency2());

        Set<Timezone> timezones = new HashSet<Timezone>();
        timezones.add(TimezoneFixture.standardTimezone());
        timezones.add(TimezoneFixture.standardTimezone2());


        Country country = CountryBuilder.aCountryBuilder()
                .withName("Country 1")
                .withFlag("FLAG " + new Date().getTime())
                .withAbbreviation_2("ABBR_2 " + new Date().getTime())
                .withAbbreviation_3("ABBR_3 " + new Date().getTime())
                .withIdd("IDD " + new Date().getTime())
                .withCities(cities)
                .withStates(states)
                .withCurrencies(currencies)
                .withTimezones(timezones)
                .build();
        return country;
    }
}
