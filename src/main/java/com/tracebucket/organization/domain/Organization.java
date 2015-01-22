package com.tracebucket.organization.domain;

import com.tracebucket.common.domain.*;
import com.tracebucket.infrastructure.ddd.annotation.AggregateRoot;
import com.tracebucket.infrastructure.ddd.domain.BaseAggregateRoot;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ffl on 11-04-2014.
 */
@AggregateRoot
@Entity
@Table(name = "ORGANIZATION")
public class Organization extends BaseAggregateRoot {

    @Column(name = "CODE", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private String code;

    @Column(name = "NAME", nullable = false, unique = true)
    @Basic(fetch = FetchType.EAGER)
    private String name;

    @Column(name = "DESCRIPTION")
    @Basic(fetch = FetchType.EAGER)
    private String description;

    @Column(name = "WEBSITE", unique = true)
    @Basic(fetch = FetchType.EAGER)
    private String website;

    @Column(name = "IMAGE")
    @Basic(fetch = FetchType.EAGER)
    protected String image;

    @ElementCollection
    @JoinTable(name = "ORGANIZATION_ADDRESS", joinColumns = @JoinColumn(name = "ORGANIZATION__ID"))
    private Set<Address> addresses = new HashSet<Address>(0);

    public enum CurrencyType{
        Base,
        Optional
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(
            name="ORGANIZATION_CURRENCY",
            joinColumns={ @JoinColumn(name="ORGANIZATION__ID", referencedColumnName="ID") },
            inverseJoinColumns={ @JoinColumn(name="CURRENCY__ID", referencedColumnName="ID", unique=true) }
    )
    private Map<Currency, CurrencyType> currencies = new HashMap<>(0);

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(
            name="ORGANIZATION_TIMEZONE",
            joinColumns={ @JoinColumn(name="ORGANIZATION__ID", referencedColumnName="ID") },
            inverseJoinColumns={ @JoinColumn(name="TIMEZONE__ID", referencedColumnName="ID", unique=true) }
    )
    private Set<Timezone> timezones = new HashSet<Timezone>(0);

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(
            name="ORGANIZATION_CONTACT_PERSON",
            joinColumns={ @JoinColumn(name="ORGANIZATION__ID", referencedColumnName="ID") },
            inverseJoinColumns={ @JoinColumn(name="PERSON__ID", referencedColumnName="ID", unique=true) }
    )
    private Set<Person> contactPersons = new HashSet<Person>(0);

    @OneToMany(mappedBy="organization", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OrganizationUnit> organizationUnits = new HashSet<OrganizationUnit>(0);

    @ElementCollection
    @JoinTable(name = "ORGANIZATION_CONTACT_PHONE", joinColumns = @JoinColumn(name = "ORGANIZATION__ID"))
    private Set<Phone> phones = new HashSet<Phone>(0);

    @ElementCollection
    @JoinTable(name = "ORGANIZATION_CONTACT_EMAIL", joinColumns = @JoinColumn(name = "ORGANIZATION__ID"))
    private Set<Email> emails = new HashSet<Email>(0);

    public Organization() {
    }

    public void addBaseCurrency(Currency baseCurrency){
        //TODO
    }

    public void addTimezone(Timezone timezone){
        //TODO
    }

    public void addOrganizationUnit(OrganizationUnit organizationUnit){
        //TODO
    }

    public void addOrganizationUnitBelow(OrganizationUnit organizationUnit, OrganizationUnit parentOrganizationUnit){
        //TODO
    }

    public void addContactPerson(Person contactPerson){
        //TODO
    }

    public void setDefaultContactPerson(Person defaultContactPerson){
        //TODO
    }

    public void addContactNumber(Phone phone){
        //TODO
    }

    public void setDefaultContactNumber(Phone defaultContactNumber){
        //TODO
    }

    public void addEmail(Email email){
        //TODO
    }

    public void setDefaultEmail(Email defaultEmail){
        //TODO
    }

    public void setHeadOffice(Address headOfficeAddress){
        //TODO
    }

    public void moveHeadOfficeTo(Address newHeadOfficeAddress){
        //TODO
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getWebsite() {
        return website;
    }

    public String getImage() {
        return image;
    }

    public Address getHeadOfficeAddress(){
        //TODO
        return null;
    }

    public Set<Currency> getBaseCurrencies(){
        //TODO
        return null;
    }

    public Set<OrganizationUnit> getOrganizationUnits(){
        //TODO
        return null;
    }

    public Set<Phone> getContactNumbers(){
        //TODO
        return null;
    }

    public Set<Email> getEmails(){
        //TODO
        return null;
    }
}
