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
    public Organization findOne(AggregateId aggregateId);
    public boolean delete(AggregateId organizationAggregateId);
    public Organization addBaseCurrency(Currency baseCurrency, AggregateId organizationAggregateId);
    public Organization addTimezone(Timezone timezone, AggregateId organizationAggregateId);
    public Organization addOrganizationUnit(OrganizationUnit organizationUnit, AggregateId organizationAggregateId);
    public Organization addOrganizationUnitBelow(OrganizationUnit organizationUnit, OrganizationUnit parentOrganizationUnit, AggregateId organizationAggregateId);
    public Organization addContactPerson(Person contactPerson, AggregateId organizationAggregateId);
    public Organization setDefaultContactPerson(Person defaultContactPerson, AggregateId organizationAggregateId);
    public Organization addContactNumber(Phone phone, AggregateId organizationAggregateId);
    public Organization setDefaultContactNumber(Phone defaultContactNumber, AggregateId organizationAggregateId);
    public Organization addEmail(Email email, AggregateId organizationAggregateId);
    public Organization setDefaultEmail(Email defaultEmail, AggregateId organizationAggregateId);
    public Organization setHeadOffice(Address headOfficeAddress, AggregateId organizationAggregateId);
    public Organization moveHeadOfficeTo(Address newHeadOfficeAddress, AggregateId organizationAggregateId);
    public Address getHeadOfficeAddress(AggregateId organizationAggregateId);
    public Set<Currency> getBaseCurrencies(AggregateId organizationAggregateId);
    public Set<OrganizationUnit> getOrganizationUnits(AggregateId organizationAggregateId);
    public Set<Phone> getContactNumbers(AggregateId organizationAggregateId);
    public Set<Email> getEmails(AggregateId organizationAggregateId);
}