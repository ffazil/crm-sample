package com.tracebucket.crm.test.fixture;

import com.tracebucket.common.dictionary.EmailType;
import com.tracebucket.common.dictionary.Gender;
import com.tracebucket.common.dictionary.PhoneType;
import com.tracebucket.common.domain.Person;
import com.tracebucket.crm.test.builder.PersonBuilder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sadath on 25-Nov-14.
 */
public class PersonFixture {

    public static Person standardPerson(){
        Map<String, EmailType> emails = new HashMap<String, EmailType>();
        emails.put("sadath@mmp.com", EmailType.PERSONAL);
        Map<String, PhoneType> phones = new HashMap<String, PhoneType>();
        phones.put("9898988889888", PhoneType.MOBILE);
        Person person = PersonBuilder.asPerson()
                .withFirstName("Syed")
                .withLastName("Sadath")
                .withGender(Gender.MALE)
                .withBirthDay(new Date())
                .withImage("Image")
                .withEmails(emails)
                .withPhones(phones)
                .build();
        return person;
    }

    public static Person standardPerson2(){
        Map<String, EmailType> emails = new HashMap<String, EmailType>();
        emails.put("firoz@mmp.com", EmailType.PERSONAL);
        Map<String, PhoneType> phones = new HashMap<String, PhoneType>();
        phones.put("23232323232", PhoneType.MOBILE);
        Person person = PersonBuilder.asPerson()
                .withFirstName("Firoz")
                .withLastName("Fazil")
                .withGender(Gender.MALE)
                .withBirthDay(new Date())
                .withImage("Image")
                .withEmails(emails)
                .withPhones(phones)
                .build();
        return person;
    }
}
