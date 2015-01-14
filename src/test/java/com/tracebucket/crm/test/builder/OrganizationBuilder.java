package com.tracebucket.crm.test.builder;

import com.tracebucket.organization.domain.Organization;
import com.tracebucket.organization.domain.OrganizationUnit;
import com.tracebucket.common.domain.*;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sadath on 25-Nov-14.
 */
public class OrganizationBuilder {
    private AggregateId aggregateId;
    private String code;
    private String name;
    private String description;
    private String website;
    protected String image;
    private Set<Address> addresses = new HashSet<Address>(0);
    private Set<Currency> currencies = new HashSet<Currency>(0);
    private Set<Timezone> timezones = new HashSet<Timezone>(0);
    private Set<Person> contactPersons = new HashSet<Person>(0);
    private Set<OrganizationUnit> organizationUnits = new HashSet<OrganizationUnit>(0);
    private Set<Phone> phones = new HashSet<Phone>(0);
    private Set<Email> emails = new HashSet<Email>(0);

    private OrganizationBuilder(){ }

    public static OrganizationBuilder anOrganizationBuilder(){
        return new OrganizationBuilder();
    }

    public OrganizationBuilder withAggregateId(AggregateId aggregateId){
        this.aggregateId = aggregateId;
        return this;
    }

    public OrganizationBuilder withCode(String code){
        this.code = code;
        return this;
    }

    public OrganizationBuilder withName(String name){
        this.name = name;
        return this;
    }

    public OrganizationBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public OrganizationBuilder withWebsite(String website){
        this.website = website;
        return this;
    }

    public OrganizationBuilder withImage(String image){
        this.image = image;
        return this;
    }

    public OrganizationBuilder withAddresses(Set<Address> addresses){
        this.addresses = addresses;
        return this;
    }

    public OrganizationBuilder withCurrencies(Set<Currency> currencies){
        this.currencies = currencies;
        return this;
    }

    public OrganizationBuilder withTimezones(Set<Timezone> timezones){
        this.timezones = timezones;
        return this;
    }

    public OrganizationBuilder withContactPersons(Set<Person> contactPersons){
        this.contactPersons = contactPersons;
        return this;
    }

    public OrganizationBuilder withOrganizationUnits(Set<OrganizationUnit> organizationUnits){
        this.organizationUnits = organizationUnits;
        return this;
    }

    public OrganizationBuilder withPhones(Set<Phone> phones){
        this.phones = phones;
        return this;
    }

    public OrganizationBuilder withEmails(Set<Email> emails){
        this.emails = emails;
        return this;
    }

    public Organization build(){
        Organization organization = new Organization();
        organization.setName(name);
        organization.setCode(code);
        organization.setContactPersons(contactPersons);
        organization.setTimezones(timezones);
        organization.setAddresses(addresses);
        organization.setCurrencies(currencies);
        organization.setDescription(description);
        organization.setEmails(emails);
        organization.setImage(image);
        if(organizationUnits != null && organizationUnits.size() > 0) {
            for(OrganizationUnit organizationUnit : organizationUnits) {
                organizationUnit.setOrganization(organization);
            }
        }
        organization.setOrganizationUnits(organizationUnits);
        organization.setWebsite(website);
        organization.setPhones(phones);
        return organization;
    }
}
