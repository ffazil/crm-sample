package com.tracebucket.crm.test.fixture;



import com.tracebucket.aggregates.partner.Customer;
import com.tracebucket.common.dictionary.Gender;
import com.tracebucket.common.domain.Address;
import com.tracebucket.crm.test.builder.CustomerBuilder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sadath on 11-Aug-14.
 */
public class CustomerFixture {
    public static Customer standardCustomer(){
        Set<Address> addresses = new HashSet<Address>(0);
        addresses.add(AddressFixture.standardAddress());
        addresses.add(AddressFixture.standardAddress2());
        Customer customer = CustomerBuilder.aCustomer()
                .withName("Customer " + new Date().getTime())
                .withBirthday(new Date())
                .withEmail("test@gmail.com")
                .withFirstName("Customer "+ new Date().getTime())
                .withMiddleName("Customer "+ new Date().getTime())
                .withLastName("Customer "+ new Date().getTime())
                .withGender(Gender.MALE)
                .withAddresses(addresses)
                .build();
        return customer;
    }
}
