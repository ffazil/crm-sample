package com.tracebucket.crm.test.fixture;

import com.tracebucket.organization.domain.Organization;
import com.tracebucket.organization.domain.OrganizationUnit;
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
        Organization organization = OrganizationBuilder.anOrganizationBuilder()
                .build("Organization " + new Date().getTime(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), "image");
        return organization;
    }

    public static Organization addBaseCurrency(Currency baseCurrency, Organization organization) {
        organization.addBaseCurrency(baseCurrency);
        return organization;
    }
    
    public static  Organization addTimezone(Timezone timezone, Organization organization) {
        organization.addTimezone(timezone);
        return organization;
    }
    
    public static  Organization addOrganizationUnit(OrganizationUnit organizationUnit, Organization organization) {
        organization.addOrganizationUnit(organizationUnit);
        return organization;
    }
    
    public static  Organization addOrganizationUnitBelow(OrganizationUnit organizationUnit, OrganizationUnit parentOrganizationUnit, Organization organization) {
        organization.addOrganizationUnitBelow(organizationUnit, parentOrganizationUnit);
        return organization;
    }
    
    public static  Organization addContactPerson(Person contactPerson, Organization organization) {
        organization.addContactPerson(contactPerson);
        return organization;
    }
    
    public static  Organization setDefaultContactPerson(Person defaultContactPerson, Organization organization) {
        organization.setDefaultContactPerson(defaultContactPerson);
        return organization;
    }
    
    public static  Organization addContactNumber(Phone phone, Organization organization) {
        organization.addContactNumber(phone);
        return organization;
    }
    
    public static  Organization setDefaultContactNumber(Phone defaultContactNumber, Organization organization) {
        organization.setDefaultContactNumber(defaultContactNumber);
        return organization;
    }
    
    public static  Organization addEmail(Email email, Organization organization) {
        organization.addEmail(email);
        return organization;
    }
    
    public static  Organization setDefaultEmail(Email defaultEmail, Organization organization) {
        organization.setDefaultEmail(defaultEmail);
        return organization;
    }
    
    public static  Organization setHeadOffice(Address headOfficeAddress, Organization organization) {
        organization.setHeadOffice(headOfficeAddress);
        return organization;
    }
    
    public static  Organization moveHeadOfficeTo(Address newHeadOfficeAddress, Organization organization) {
        organization.moveHeadOfficeTo(newHeadOfficeAddress);
        return organization;
    }

}
