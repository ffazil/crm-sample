package com.tracebucket.crm.test.fixture;

import com.tracebucket.aggregates.partner.EntertainmentCompany;
import com.tracebucket.common.domain.Person;
import com.tracebucket.crm.test.builder.EntertainmentCompanyBuilder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vishwa on 14-01-2015.
 */
public class EntertainmentCompanyFixture {

    public static EntertainmentCompany standardEntertainmentCompany() {

        Set<Person> persons = new HashSet<Person>();
        persons.add(PersonFixture.standardPerson());

        EntertainmentCompany entertainmentCompany = EntertainmentCompanyBuilder.anEntertainmentCompanyBuilder()
                .withName("Ent_Comp " + new Date().getTime())
                .withLogo("Logo")
                .withWebsite("http://test.com")
                .withContactPersons(persons)
                 .build();
        return entertainmentCompany;
        }

   }



