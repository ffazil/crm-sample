package com.tracebucket.crm.test.builder;

import com.tracebucket.partner.domain.EntertainmentCompany;
import com.tracebucket.common.domain.Person;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vishwa on 14-01-2015.
 */
public class EntertainmentCompanyBuilder {

    protected String name;

    protected String website;

    protected String logo;

   protected Set<Person> contactPersons = new HashSet<Person>(0);

    public EntertainmentCompanyBuilder() {
    }

    public static EntertainmentCompanyBuilder anEntertainmentCompanyBuilder(){
        return new EntertainmentCompanyBuilder();
    }

    public EntertainmentCompanyBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public EntertainmentCompanyBuilder withWebsite(String website) {
        this.website = website;
        return this;
    }

    public EntertainmentCompanyBuilder withLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public EntertainmentCompanyBuilder withContactPersons(Set<Person> contactPersons) {
        this.contactPersons = contactPersons;
        return this;
    }

    public EntertainmentCompany build() {
        EntertainmentCompany entertainmentCompany = new EntertainmentCompany();
        entertainmentCompany.setName(name);
        entertainmentCompany.setWebsite(website);
        entertainmentCompany.setLogo(logo);
        entertainmentCompany.setContactPersons(contactPersons);

        return entertainmentCompany;
    }
}
