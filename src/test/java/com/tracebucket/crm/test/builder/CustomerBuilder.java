package com.tracebucket.crm.test.builder;

import com.tracebucket.partner.domain.Customer;
import com.tracebucket.common.dictionary.Gender;
import com.tracebucket.common.domain.Address;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CustomerBuilder {
    private String name;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDay;
    private Gender gender;
    private String email;
    private Set<Address> addresses = new HashSet<Address>(0);

    public CustomerBuilder(){

    }

    public static CustomerBuilder aCustomer(){
        return new CustomerBuilder();
    }

    public CustomerBuilder withName(String name){
        this.name = name;
        return this;
    }

    public CustomerBuilder withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public CustomerBuilder withMiddleName(String middleName){
        this.middleName = middleName;
        return this;
    }

    public CustomerBuilder withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public CustomerBuilder withBirthday(Date birthDay){
        this.birthDay = birthDay;
        return this;
    }

    public CustomerBuilder withGender(Gender gender){
        this.gender = gender;
        return this;
    }

    public CustomerBuilder withEmail(String email){
        this.email = email;
        return this;
    }

    public CustomerBuilder withAddresses(Set<Address> addresses){
        this.addresses = addresses;
        return this;
    }

    public Customer build() {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setFirstName(firstName);
        customer.setMiddleName(middleName);
        customer.setLastName(lastName);
        customer.setBirthDay(birthDay);
        customer.setGender(gender);
        customer.setEmail(email);
        customer.setAddresses(addresses);
        return customer;
    }
}
