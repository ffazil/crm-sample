package com.tracebucket.organization;

import com.tracebucket.common.dictionary.OrganizationFunction;
import com.tracebucket.common.domain.*;
import com.tracebucket.infrastructure.ddd.domain.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ffl on 11-04-2014.
 */
@Entity
@Table(name = "ORGANIZATION_UNIT")
public class OrganizationUnit extends BaseEntity {

    @Column(name = "NAME", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private String name;

    @Column(name = "DESCRIPTION")
    @Basic(fetch = FetchType.EAGER)
    private String description;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="ORGANIZATION__ID")
    private Organization organization;

    @ManyToOne(fetch = FetchType.EAGER)
    private OrganizationUnit parent;

    @ElementCollection(targetClass=OrganizationFunction.class, fetch = FetchType.EAGER)
    @JoinTable(name = "ORGANIZATION_UNIT_FUNCTION", joinColumns = @JoinColumn(name = "ORGANIZATION_UNIT__ID"))
    @Enumerated(EnumType.STRING)
    @Column(name = "ORGANIZATION_FUNCTION", nullable = false, columnDefinition = "ENUM('SALES','PURCHASE') default 'SALES'")
    private Set<OrganizationFunction> organizationFunctions = new HashSet<OrganizationFunction>(0);

    @ElementCollection
    @JoinTable(name = "ORGANIZATION_UNIT_ADDRESS", joinColumns = @JoinColumn(name = "ORGANIZATION_UNIT__ID"))
    private Set<Address> addresses = new HashSet<Address>(0);

    @ElementCollection
    @JoinTable(name = "ORGANIZATION_UNIT_CONTACT_PERSON", joinColumns = @JoinColumn(name = "ORGANIZATION_UNIT__ID"))
    private Set<Person> contactPersons = new HashSet<Person>(0);

    @ElementCollection
    @JoinTable(name = "ORGANIZATION_UNIT_CONTACT_PHONE", joinColumns = @JoinColumn(name = "ORGANIZATION_UNIT__ID"))
    private Set<Phone> phones = new HashSet<Phone>(0);

    @ElementCollection
    @JoinTable(name = "ORGANIZATION_UNIT_CONTACT_EMAIL", joinColumns = @JoinColumn(name = "ORGANIZATION_UNIT__ID"))
    private Set<Email> emails = new HashSet<Email>(0);

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name="ORGANIZATION_UNIT__ID", referencedColumnName="ID")
    private Set<Department> departments = new HashSet<Department>(0);

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name="ORGANIZATION_UNIT__ID", referencedColumnName="ID")
    private Set<BusinessLine> businessLines = new HashSet<BusinessLine>(0);

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<OrganizationUnit> children = new HashSet<OrganizationUnit>(0);

    @OneToMany(mappedBy="organizationUnit", fetch = FetchType.EAGER)
    private Set<SaleChannel> saleChannels = new HashSet<SaleChannel>(0);

    public OrganizationUnit() {
    }

    public Boolean hasAddresses(){
        if(this.addresses == null)
            return false;
        if(this.addresses.size() <= 0)
            return false;
        return true;

    }

    public OrganizationUnit address(Address address){
        this.addresses.add(address);
        return this;
    }

    public Set<Address> addresses(){
        return this.addresses;
    }

    public OrganizationUnit parent(){
        return this.parent;
    }

    public Set<OrganizationUnit> children(){
        return this.children;
    }

    public Organization owner(){
        return this.organization;
    }

    public OrganizationUnit function(OrganizationFunction organizationFunction){
        this.organizationFunctions.add(organizationFunction);
        return this;
    }

    public Set<OrganizationFunction> functions(){
        return this.organizationFunctions;
    }

    public OrganizationUnit department(Department department){
        this.departments.add(department);
        return this;
    }

    public Boolean hasSaleChannels(){
        if(saleChannels == null)
            return false;
        if(saleChannels.size() <= 0)
            return false;
        return true;
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public OrganizationUnit getParent() {
        return parent;
    }

    public void setParent(OrganizationUnit parent) {
        this.parent = parent;
    }

    public Set<OrganizationFunction> getOrganizationFunctions() {
        return organizationFunctions;
    }

    public void setOrganizationFunctions(Set<OrganizationFunction> organizationFunctions) {
        this.organizationFunctions = organizationFunctions;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Set<BusinessLine> getBusinessLines() {
        return businessLines;
    }

    public void setBusinessLines(Set<BusinessLine> businessLines) {
        this.businessLines = businessLines;
    }

    public Set<OrganizationUnit> getChildren() {
        return children;
    }

    public void setChildren(Set<OrganizationUnit> children) {
        this.children = children;
        for(OrganizationUnit child : children){
            child.setParent(this);
        }
    }

    public void addChild(OrganizationUnit child){
        child.setParent(this);
        this.children.add(child);
    }

    public Set<SaleChannel> getSaleChannels() {
        return saleChannels;
    }

    public void setSaleChannels(Set<SaleChannel> saleChannels) {
        this.saleChannels = saleChannels;
    }

    public Set<Person> getContactPersons() {
        return contactPersons;
    }

    public void setContactPersons(Set<Person> contactPersons) {
        this.contactPersons = contactPersons;
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
}
