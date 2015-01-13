package com.tracebucket.crm.test.builder;

import com.tracebucket.aggregates.organization.*;
import com.tracebucket.common.dictionary.OrganizationFunction;
import com.tracebucket.common.domain.Address;
import com.tracebucket.common.domain.Email;
import com.tracebucket.common.domain.Person;
import com.tracebucket.common.domain.Phone;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sadath on 25-Nov-14.
 */
public class OrganizationUnitBuilder {
    private String name;
    private String description;
    private Organization organization;
    private OrganizationUnit parent;
    private Set<OrganizationFunction> organizationFunctions = new HashSet<OrganizationFunction>(0);
    private Set<Address> addresses = new HashSet<Address>(0);
    private Set<Person> contactPersons = new HashSet<Person>(0);
    private Set<Phone> phones = new HashSet<Phone>(0);
    private Set<Email> emails = new HashSet<Email>(0);
    private Set<Department> departments = new HashSet<Department>(0);
    private Set<BusinessLine> businessLines = new HashSet<BusinessLine>(0);
    private Set<OrganizationUnit> children = new HashSet<OrganizationUnit>(0);
    private Set<SaleChannel> saleChannels = new HashSet<SaleChannel>(0);

    private OrganizationUnitBuilder(){ }

    public static OrganizationUnitBuilder anOrganizationUnitBuilder(){
        return new OrganizationUnitBuilder();
    }

    public OrganizationUnitBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public OrganizationUnitBuilder withName(String name){
        this.name = name;
        return this;
    }

    public OrganizationUnitBuilder withOrganization(Organization organization){
        this.organization = organization;
        return this;
    }

    public OrganizationUnitBuilder withParent(OrganizationUnit parent){
        this.parent = parent;
        return this;
    }

    public OrganizationUnitBuilder withOrganizationFunctions(Set<OrganizationFunction> organizationFunctions){
        this.organizationFunctions = organizationFunctions;
        return this;
    }

    public OrganizationUnitBuilder withAddresses(Set<Address> addresses){
        this.addresses = addresses;
        return this;
    }

    public OrganizationUnitBuilder withContactPersons(Set<Person> contactPersons){
        this.contactPersons = contactPersons;
        return this;
    }

    public OrganizationUnitBuilder withPhones(Set<Phone> phones){
        this.phones = phones;
        return this;
    }

    public OrganizationUnitBuilder withEmails(Set<Email> emails){
        this.emails = emails;
        return this;
    }

    public OrganizationUnitBuilder withDepartments(Set<Department> departments){
        this.departments = departments;
        return this;
    }

    public OrganizationUnitBuilder withBusinessLines(Set<BusinessLine> businessLines){
        this.businessLines = businessLines;
        return this;
    }

    public OrganizationUnitBuilder withChildren(Set<OrganizationUnit> children){
        this.children = children;
        return this;
    }

    public OrganizationUnitBuilder withSaleChannels(Set<SaleChannel> saleChannels){
        this.saleChannels = saleChannels;
        return this;
    }

    public OrganizationUnit build(){
        OrganizationUnit organizationUnit = new OrganizationUnit();
        organizationUnit.setName(name);
        organizationUnit.setDescription(description);
        organizationUnit.setContactPersons(contactPersons);
        organizationUnit.setPhones(phones);
        organizationUnit.setAddresses(addresses);
        organizationUnit.setBusinessLines(businessLines);
        organizationUnit.setChildren(children);
        organizationUnit.setDepartments(departments);
        organizationUnit.setSaleChannels(saleChannels);
        organizationUnit.setOrganizationFunctions(organizationFunctions);
        organizationUnit.setEmails(emails);
        organizationUnit.setParent(parent);
        organizationUnit.setOrganization(organization);
        return organizationUnit;
    }

}
