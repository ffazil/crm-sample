package com.tracebucket.organization.service.impl;

import com.tracebucket.common.domain.*;
import com.tracebucket.crm.service.CurrencyService;
import com.tracebucket.organization.service.OrganizationService;
import com.tracebucket.infrastructure.ddd.annotation.PersistChanges;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;
import com.tracebucket.organization.domain.Organization;
import com.tracebucket.organization.domain.OrganizationUnit;
import com.tracebucket.organization.repository.jpa.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by sadath on 22-Jan-15.
 */
@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private CurrencyService currencyService;

    @Override
    public Organization save(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public Organization findOne(AggregateId aggregateId) {
        return organizationRepository.findOne(aggregateId);
    }

    @Override
    public boolean delete(AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organizationRepository.delete(organization);
            return organizationRepository.findOne(organizationAggregateId) == null ? true : false;
        }
        return false;
    }

    @Override
    @PersistChanges(repository = "organizationRepository")
    public Organization addBaseCurrency(Currency baseCurrency, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            Currency currency = currencyService.findOne(baseCurrency.getEntityId());
            if(currency != null) {
                organization.addBaseCurrency(currency);
                return organization;
            }
        }
        return null;
    }

    @Override
    @PersistChanges(repository = "organizationRepository")
    public Organization addTimezone(Timezone timezone, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.addTimezone(timezone);
            return organization;
        }
        return null;
    }

    @Override
    @PersistChanges(repository = "organizationRepository")
    public Organization addOrganizationUnit(OrganizationUnit organizationUnit, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.addOrganizationUnit(organizationUnit);
            return organization;
        }
        return null;
    }

    @Override
    @PersistChanges(repository = "organizationRepository")
    public Organization addOrganizationUnitBelow(OrganizationUnit organizationUnit, OrganizationUnit parentOrganizationUnit, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.addOrganizationUnitBelow(organizationUnit, parentOrganizationUnit);
            return  organization;
        }
        return null;
    }

    @Override
    @PersistChanges(repository = "organizationRepository")
    public Organization addContactPerson(Person contactPerson, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.addContactPerson(contactPerson);
            return organization;
        }
        return null;
    }

    @Override
    @PersistChanges(repository = "organizationRepository")
    public Organization setDefaultContactPerson(Person defaultContactPerson, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.setDefaultContactPerson(defaultContactPerson);
            return organization;
        }
        return null;
    }

    @Override
    @PersistChanges(repository = "organizationRepository")
    public Organization addContactNumber(Phone phone, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.addContactNumber(phone);
            return organization;
        }
        return null;
    }

    @Override
    @PersistChanges(repository = "organizationRepository")
    public Organization setDefaultContactNumber(Phone defaultContactNumber, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.setDefaultContactNumber(defaultContactNumber);
            return organization;
        }
        return null;
    }

    @Override
    @PersistChanges(repository = "organizationRepository")
    public Organization addEmail(Email email, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.addEmail(email);
            return organization;
        }
        return null;
    }

    @Override
    @PersistChanges(repository = "organizationRepository")
    public Organization setDefaultEmail(Email defaultEmail, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.setDefaultEmail(defaultEmail);
            return organization;
        }
        return null;
    }

    @Override
    @PersistChanges(repository = "organizationRepository")
    public Organization setHeadOffice(Address headOfficeAddress, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.setHeadOffice(headOfficeAddress);
            return organization;
        }
        return null;
    }

    @Override
    @PersistChanges(repository = "organizationRepository")
    public Organization moveHeadOfficeTo(Address newHeadOfficeAddress, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.moveHeadOfficeTo(newHeadOfficeAddress);
            return organization;
        }
        return null;
    }

    @Override
    public Address getHeadOfficeAddress(AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            return organization.getHeadOfficeAddress();
        }
        return null;
    }

    @Override
    public Set<Currency> getBaseCurrencies(AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            return organization.getBaseCurrencies();
        }
        return null;
    }

    @Override
    public Set<OrganizationUnit> getOrganizationUnits(AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            return organization.getOrganizationUnits();
        }
        return null;
    }

    @Override
    public Set<Phone> getContactNumbers(AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            return organization.getContactNumbers();
        }
        return null;
    }

    @Override
    public Set<Email> getEmails(AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            return organization.getEmails();
        }
        return null;
    }
}
