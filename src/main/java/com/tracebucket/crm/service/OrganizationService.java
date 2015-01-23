package com.tracebucket.crm.service;

import com.tracebucket.common.domain.*;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;
import com.tracebucket.organization.domain.Organization;
import com.tracebucket.organization.domain.OrganizationUnit;

import java.util.Set;

/**
 * Created by sadath on 23-Jan-15.
 */
public interface OrganizationService {
    public Organization save(Organization organization);
    public boolean delete(AggregateId organizationAggregateId);
    public void addBaseCurrency(Currency baseCurrency, AggregateId organizationAggregateId);
    public void addTimezone(Timezone timezone, AggregateId organizationAggregateId);
    public void addOrganizationUnit(OrganizationUnit organizationUnit, AggregateId organizationAggregateId);
    public void addOrganizationUnitBelow(OrganizationUnit organizationUnit, OrganizationUnit parentOrganizationUnit, AggregateId organizationAggregateId);
    public void addContactPerson(Person contactPerson, AggregateId organizationAggregateId);
    public void setDefaultContactPerson(Person defaultContactPerson, AggregateId organizationAggregateId);
    public void addContactNumber(Phone phone, AggregateId organizationAggregateId);
    public void setDefaultContactNumber(Phone defaultContactNumber, AggregateId organizationAggregateId);
    public void addEmail(Email email, AggregateId organizationAggregateId);
    public void setDefaultEmail(Email defaultEmail, AggregateId organizationAggregateId);
    public void setHeadOffice(Address headOfficeAddress, AggregateId organizationAggregateId);
    public void moveHeadOfficeTo(Address newHeadOfficeAddress, AggregateId organizationAggregateId);
    public Address getHeadOfficeAddress(AggregateId organizationAggregateId);
    public Set<Currency> getBaseCurrencies(AggregateId organizationAggregateId);
    public Set<OrganizationUnit> getOrganizationUnits(AggregateId organizationAggregateId);
    public Set<Phone> getContactNumbers(AggregateId organizationAggregateId);
    public Set<Email> getEmails(AggregateId organizationAggregateId);
}