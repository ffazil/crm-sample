package com.tracebucket.crm.test.builder;

import com.tracebucket.common.dictionary.EmailType;
import com.tracebucket.common.dictionary.Gender;
import com.tracebucket.common.dictionary.PersonType;
import com.tracebucket.common.dictionary.PhoneType;
import com.tracebucket.common.domain.Person;

import java.util.*;

/**
 * Created by sadath on 25-Nov-14.
 */
public class PersonBuilder {

    private String firstName;
    private String lastName;
    private Date birthDay;
    private Gender gender;
    private String image;
    private Map<String, EmailType> emails = new HashMap<String, EmailType>();
    private Map<String, PhoneType> phones = new HashMap<String, PhoneType>();
    private Set<PersonType> personTypes = new HashSet<PersonType>();

    private PersonBuilder(){

    }

    public static PersonBuilder asPerson(){
        return new PersonBuilder();
    }

    public PersonBuilder withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder withBirthDay(Date birthDay)
    {
        this.birthDay = birthDay;
        return this;
    }

    public PersonBuilder withGender(Gender gender){
        this.gender = gender;
        return this;
    }

    public PersonBuilder withImage(String image){
        this.image = image;
        return this;
    }

    public PersonBuilder withEmails(Map<String, EmailType> emails){
        this.emails = emails;
        return this;
    }

    public PersonBuilder withPhones(Map<String, PhoneType> phones){
        this.phones = phones;
        return this;
    }

    public PersonBuilder withPersonTypes(Set<PersonType> personTypes){
        this.personTypes = personTypes;
        return this;
    }

    public Person build(){
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setBirthDay(birthDay);
        person.setGender(gender);
        person.setImage(image);
        person.setEmails(emails);
        person.setPhones(phones);
        person.setPersonTypes(personTypes);
        return person;
    }
}
