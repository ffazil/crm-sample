package com.tracebucket.crm.test.fixture;

import com.tracebucket.organization.domain.BusinessLine;
import com.tracebucket.organization.domain.Department;
import com.tracebucket.organization.domain.Organization;
import com.tracebucket.organization.domain.OrganizationUnit;
import com.tracebucket.common.dictionary.OrganizationFunction;
import com.tracebucket.common.domain.Address;
import com.tracebucket.common.domain.Email;
import com.tracebucket.common.domain.Person;
import com.tracebucket.common.domain.Phone;
import com.tracebucket.crm.test.builder.OrganizationUnitBuilder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by sadath on 25-Nov-14.
 */
public class OrganizationUnitFixture {
    public static OrganizationUnit standardOrganizationUnit(){
        Organization organization = null;
        OrganizationUnit parent = null;

        Set<Phone> phones = new HashSet<Phone>();
        phones.add(PhoneFixture.standardPhone());

        Set<Email> emails = new HashSet<Email>();
        emails.add(EmailFixture.standardEmail());

        Set<Person> contactPersons = new HashSet<Person>();
        contactPersons.add(PersonFixture.standardPerson());
        contactPersons.add(PersonFixture.standardPerson2());

        Set<Address> addresses = new HashSet<Address>();
        addresses.add(AddressFixture.standardAddress());
        addresses.add(AddressFixture.headOffice());

        Set<Department> departments = new HashSet<Department>();
        departments.add(DepartmentFixture.standardDepartment());

        Set<BusinessLine> businessLines = new HashSet<BusinessLine>();
        businessLines.add(BusinessLineFixture.standardBusinessLine());

        Set<OrganizationFunction> organizationFunctions = new HashSet<OrganizationFunction>();
        organizationFunctions.add(OrganizationFunction.SALES);
        organizationFunctions.add(OrganizationFunction.PURCHASE);

/*        Set<SaleChannel> saleChannels = new HashSet<SaleChannel>();
        saleChannels.add(SaleChannelFixture.standardSaleChannelStore());*/

/*        Set<OrganizationUnit> children = new HashSet<OrganizationUnit>();
        children.add(OrganizationUnitFixture.standardOrganizationUnit());*/

        OrganizationUnit organizationUnit = OrganizationUnitBuilder.anOrganizationUnitBuilder()
                .withName("Organization " + new Date().getTime())
                .withDescription(UUID.randomUUID().toString())
                .withEmails(emails)
                .withPhones(phones)
                .withContactPersons(contactPersons)
                .withAddresses(addresses)
                .withBusinessLines(businessLines)
                //.withChildren(children)
                .withDepartments(departments)
                .withOrganizationFunctions(organizationFunctions)
               // .withSaleChannels(saleChannels)
                .withOrganization(organization)
                .withParent(parent)
                .build();
        return organizationUnit;
    }
}
