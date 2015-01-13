package com.tracebucket.aggregates.organization;

import com.tracebucket.common.domain.*;
import com.tracebucket.infrastructure.ddd.annotation.AggregateRoot;
import com.tracebucket.infrastructure.ddd.domain.BaseAggregateRoot;

import javax.persistence.*;
import java.util.HashSet;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(
            name="ORGANIZATION_CURRENCY",
            joinColumns={ @JoinColumn(name="ORGANIZATION__ID", referencedColumnName="ID") },
            inverseJoinColumns={ @JoinColumn(name="CURRENCY__ID", referencedColumnName="ID", unique=true) }
    )
    private Set<Currency> currencies = new HashSet<Currency>(0);

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(
            name="ORGANIZATION_TIMEZONE",
            joinColumns={ @JoinColumn(name="ORGANIZATION__ID", referencedColumnName="ID") },
            inverseJoinColumns={ @JoinColumn(name="TIMEZONE__ID", referencedColumnName="ID", unique=true) }
    )
    private Set<Timezone> timezones = new HashSet<Timezone>(0);

    @ElementCollection
    @JoinTable(name = "ORGANIZATION_CONTACT_PERSON", joinColumns = @JoinColumn(name = "ORGANIZATION_UNIT__ID"))
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

    public Boolean hasAddresses(){
        if(this.addresses == null)
            return false;
        if(this.addresses.size() <= 0)
            return false;
        return true;

    }

    public Organization address(Address address){
        this.addresses.add(address);
        return this;
    }

    public Set<Address> addresses(){
        return this.addresses;
    }

    public Boolean hasContactPersons(){
        if(this.contactPersons == null)
            return false;
        if(this.contactPersons.size() <= 0)
            return false;
        return true;
    }

    public Organization contactPerson(Person person){
        this.contactPersons.add(person);
        return this;
    }

    public Set<Person> contactPersons(){
        return this.contactPersons;
    }

    public Organization organizationUnit(OrganizationUnit organizationUnit){
        this.organizationUnits.add(organizationUnit);
        return this;
    }

    public Boolean hasOrganizationUnits(){
        if(this.organizationUnits == null)
            return false;
        if(this.organizationUnits.size() <= 0)
            return false;
        return true;
    }

    public Set<OrganizationUnit> organizationUnits(){
        return this.organizationUnits;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Person> getContactPersons() {
        return contactPersons;
    }

    public void setContactPersons(Set<Person> contactPersons) {
        this.contactPersons = contactPersons;
    }

    public Set<OrganizationUnit> getOrganizationUnits() {
        return organizationUnits;
    }

    public void setOrganizationUnits(Set<OrganizationUnit> organizationUnits) {
        this.organizationUnits = organizationUnits;
    }

    public Set<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Set<Currency> currencies) {
        this.currencies = currencies;
    }

    public Set<Timezone> getTimezones() {
        return timezones;
    }

    public void setTimezones(Set<Timezone> timezones) {
        this.timezones = timezones;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    public Set<Email> getEmails() {
        return emails;
    }

    public void setEmails(Set<Email> emails) {
        this.emails = emails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organization)) return false;
        if (!super.equals(o)) return false;

        Organization that = (Organization) o;

        if (!code.equals(that.code)) return false;
        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + code.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
