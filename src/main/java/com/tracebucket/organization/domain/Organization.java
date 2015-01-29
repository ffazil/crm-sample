package com.tracebucket.organization.domain;

import com.tracebucket.common.dictionary.AddressType;
import com.tracebucket.common.domain.*;
import com.tracebucket.infrastructure.ddd.annotation.AggregateRoot;
import com.tracebucket.infrastructure.ddd.annotation.DomainMethod;
import com.tracebucket.infrastructure.ddd.domain.BaseAggregateRoot;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * Created by ffl on 11-04-2014.
 */
@AggregateRoot
@Entity
@Table(name = "ORGANIZATION")
@EntityListeners(value = {})
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

    @ElementCollection
    @CollectionTable(name = "ORGANIZATION_CURRENCY", joinColumns = @JoinColumn(name = "ORGANIZATION__ID"))
    @Column(name = "CURRENCY_TYPE")
    @MapKeyJoinColumn(name = "CURRENCY__ID", referencedColumnName = "ID")
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
            name = "ORGANIZATION_CONTACT_PERSON",
            joinColumns = { @JoinColumn(name = "ORGANIZATION__ID", referencedColumnName = "ID") },
            inverseJoinColumns = { @JoinColumn(name = "PERSON__ID", referencedColumnName = "ID", unique = true) }
    )
    private Set<Person> contactPersons = new HashSet<Person>(0);

    @OneToMany(mappedBy = "organization", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OrganizationUnit> organizationUnits = new HashSet<OrganizationUnit>(0);

    @ElementCollection
    @JoinTable(name = "ORGANIZATION_CONTACT_PHONE", joinColumns = @JoinColumn(name = "ORGANIZATION__ID"))
    private Set<Phone> phones = new HashSet<Phone>(0);

    @ElementCollection
    @JoinTable(name = "ORGANIZATION_CONTACT_EMAIL", joinColumns = @JoinColumn(name = "ORGANIZATION__ID"))
    private Set<Email> emails = new HashSet<Email>(0);

    public Organization() {
    }

    public Organization(String name, String code, String description) {
        this.name = name;
        this.code = code;
        this.description = description;
    }

    public Organization(String name, String code, String description, String website, String image) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.website = website;
        this.image = image;
    }

    @DomainMethod(event = "BaseCurrencyAdded")
    public void addBaseCurrency(Currency baseCurrency){
        this.currencies.put(baseCurrency, CurrencyType.Base);
    }

    @DomainMethod(event = "TimeZoneAdded")
    public void addTimezone(Timezone timezone){
        this.timezones.add(timezone);
    }

    @DomainMethod(event = "OrganizationUnitAdded")
    public void addOrganizationUnit(OrganizationUnit organizationUnit){
        if(organizationUnit != null) {
            organizationUnit.setOrganization(this);
            this.organizationUnits.add(organizationUnit);
        }
    }

    @DomainMethod(event = "OrganizationUnitAddedBelow")
    public void addOrganizationUnitBelow(OrganizationUnit organizationUnit, OrganizationUnit parentOrganizationUnit){
        OrganizationUnit parentOrganizationUnitFetched = organizationUnits.parallelStream()
                .filter(t -> t.getId() == parentOrganizationUnit.getId())
                .findFirst()
                .get();
        if(parentOrganizationUnitFetched != null) {
            parentOrganizationUnitFetched.addChild(organizationUnit);
        }
    }

    @DomainMethod(event = "ContactPersonAdded")
    public void addContactPerson(Person contactPerson){
        this.contactPersons.add(contactPerson);
    }

    @DomainMethod(event = "DefaultContactPersonSet")
    public void setDefaultContactPerson(Person defaultContactPerson){
        this.contactPersons.add(defaultContactPerson);
    }

    @DomainMethod(event = "ContactNumberAdded")
    public void addContactNumber(Phone phone){
        this.phones.add(phone);
    }

    @DomainMethod(event = "DefaultContactNumberSet")
    public void setDefaultContactNumber(Phone defaultContactNumber){
        this.phones.add(defaultContactNumber);
    }

    @DomainMethod(event = "EmailAdded")
    public void addEmail(Email email){
        this.emails.add(email);
    }

    @DomainMethod(event = "DefaultEmailSet")
    public void setDefaultEmail(Email defaultEmail){
        this.emails.add(defaultEmail);
    }

    @DomainMethod(event = "HeadOfficeSet")
    public void setHeadOffice(Address headOfficeAddress){
        this.addresses.add(headOfficeAddress);
    }

    @DomainMethod(event = "HeadOfficeMoved")
    public void moveHeadOfficeTo(Address newHeadOfficeAddress){
        this.addresses.add(newHeadOfficeAddress);
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
        Address headOfficeAddress =
                addresses.parallelStream()
                        .filter(t -> t.getAddressType() == AddressType.HEAD_OFFICE)
                        //.filter(t -> t.isCurrentAddress())
                        .findFirst()
                        .get();
        return headOfficeAddress;
    }

    public Set<Currency> getBaseCurrencies(){
          Set<Currency> baseCurrencies = new HashSet<Currency>();
/*        Set<Map.Entry<Currency, CurrencyType>> baseCurrency = currencies.entrySet().parallelStream()
                    .filter(t -> t.getValue() == CurrencyType.Base)
                    .collect(Collectors.toMap(t -> t.getKey(), t -> t.getValue())).entrySet();*/
        if(currencies != null && currencies.size() > 0) {
            for (Map.Entry<Currency, CurrencyType> currencyTypeEntry : currencies.entrySet()) {
                if(currencyTypeEntry.getValue().equals(CurrencyType.Base)) {
                    baseCurrencies.add(currencyTypeEntry.getKey());
                }
            }
        }
        return baseCurrencies;
    }

    public Set<OrganizationUnit> getOrganizationUnits(){
        return this.organizationUnits;
    }

    public Set<Phone> getContactNumbers(){
        return this.phones;
    }

    public Set<Email> getEmails(){
        return this.emails;
    }

    public Set<Timezone> getTimezones(){
        return this.timezones;
    }

    public Set<Person> getContactPersons() {
        return contactPersons;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Map<Currency, CurrencyType> getCurrencies() {
        return currencies;
    }
}
