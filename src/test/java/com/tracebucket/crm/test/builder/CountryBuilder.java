package com.tracebucket.crm.test.builder;

import com.tracebucket.common.domain.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sadath on 24-Nov-14.
 */
public class CountryBuilder {
    private String name;
    private String abbreviation_2;
    private String abbreviation_3;
    private String idd;
    private String flag;
    private Set<State> states = new HashSet<State>(0);
    private Set<City> cities = new HashSet<City>(0);
   /* private Map<Currency, CurrencyType> currencies = new HashMap<Currency, CurrencyType>(0);*/
    private Set<CountryCurrency> currencies = new HashSet<CountryCurrency>(0);
    private Set<Timezone> timezones = new HashSet<Timezone>(0);

    private CountryBuilder(){ }

    public static CountryBuilder aCountryBuilder(){
        return new CountryBuilder();
    }

    public CountryBuilder withName(String name){
        this.name = name;
        return this;
    }

    public CountryBuilder withAbbreviation_2(String abbreviation_2){
        this.abbreviation_2 = abbreviation_2;
        return this;
    }

    public CountryBuilder withAbbreviation_3(String abbreviation_3){
        this.abbreviation_3 = abbreviation_3;
        return this;
    }

    public CountryBuilder withIdd(String idd){
        this.idd = idd;
        return this;
    }

    public CountryBuilder withFlag(String flag){
        this.flag = flag;
        return this;
    }

    public CountryBuilder withStates(Set<State> states){
        this.states = states;
        return this;
    }

    public CountryBuilder withCities(Set<City> cities){
        this.cities = cities;
        return this;
    }

/*    public CountryBuilder withCurrencies(Map<Currency, CurrencyType>  currencies){
        this.currencies = currencies;
        return this;
    }*/

    public CountryBuilder withCurrencies(Set<CountryCurrency> currencies){
        this.currencies = currencies;
        return this;
    }

    public CountryBuilder withTimezones(Set<Timezone> timezones){
        this.timezones = timezones;
        return this;
    }

    public Country build(){
        Country country = new Country();
        country.setName(name);
        country.setAbbreviation_2(abbreviation_2);
        country.setAbbreviation_3(abbreviation_3);
        country.setFlag(flag);
        country.setIdd(idd);
        country.setCities(cities);
        country.setCurrencies(currencies);
        country.setStates(states);
        country.setTimezones(timezones);
        return country;
    }

}
