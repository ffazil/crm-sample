package com.tracebucket.crm.test.fixture;

import com.tracebucket.partner.domain.Affiliate;
import com.tracebucket.common.domain.Address;
import com.tracebucket.common.domain.Person;
import com.tracebucket.crm.test.builder.AffiliateBuilder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sadath on 11-Aug-14.
 */
public class AffiliateFixture {
    public static Affiliate standardAffiliate() {
        Set<Address> addresses = new HashSet<Address>(0);
        addresses.add(AddressFixture.standardAddress());
        addresses.add(AddressFixture.headOffice());

        Set<Person> persons = new HashSet<Person>(0);
        persons.add(PersonFixture.standardPerson());
        persons.add(PersonFixture.standardPerson2());

        Affiliate affiliate = AffiliateBuilder.aAffiliate()
                .withName("Affiliate " + new Date().getTime())
                .withCode("Code " + new Date().getTime())
                .withBusinessName("Business Name "+ new Date().getTime())
                .withDateOfIncorporation(new Date())
                .withLogo("Logo")
                .withWebsite("http://test.com")
                .withAddresses(addresses)
                .withPersons(persons)
                //.withSaleChannels(saleChannels)
                .build();
        return affiliate;
    }
}
