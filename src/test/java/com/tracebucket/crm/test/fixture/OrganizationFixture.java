package com.tracebucket.crm.test.fixture;

import com.tracebucket.aggregates.organization.Organization;
import com.tracebucket.aggregates.organization.OrganizationUnit;
import com.tracebucket.common.domain.*;
import com.tracebucket.crm.test.builder.OrganizationBuilder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by sadath on 25-Nov-14.
 */
public class OrganizationFixture {
    public static Organization standardOrganization() {
        Set<Address> addresses = new HashSet<Address>();
        addresses.add(AddressFixture.standardAddress());
        addresses.add(AddressFixture.standardAddress2());

        Set<Currency> currencies = new HashSet<Currency>();
        currencies.add(CurrencyFixture.standardCurrency());
        currencies.add(CurrencyFixture.standardCurrency2());

        Set<Timezone> timezones = new HashSet<Timezone>();
        timezones.add(TimezoneFixture.standardTimezone());
        timezones.add(TimezoneFixture.standardTimezone2());

        Set<Person> contactPersons = new HashSet<Person>();
        contactPersons.add(PersonFixture.standardPerson());
        contactPersons.add(PersonFixture.standardPerson2());

        Set<OrganizationUnit> organizationUnits = new HashSet<OrganizationUnit>();
        organizationUnits.add(OrganizationUnitFixture.standardOrganizationUnit());

        Set<Phone> phones = new HashSet<Phone>();
        phones.add(PhoneFixture.standardPhone());

        Set<Email> emails = new HashSet<Email>();
        emails.add(EmailFixture.standardEmail());

        Organization organization = OrganizationBuilder.anOrganizationBuilder()
                .withName("Organization " + new Date().getTime())
                .withImage("image")
                .withCode(UUID.randomUUID().toString())
                .withDescription(UUID.randomUUID().toString())
                .withWebsite(UUID.randomUUID().toString())
                .withAddresses(addresses)
                .withCurrencies(currencies)
                .withTimezones(timezones)
                .withContactPersons(contactPersons)
                .withOrganizationUnits(organizationUnits)
                .withPhones(phones)
                .withEmails(emails)
                .build();
        return organization;
    }
}
