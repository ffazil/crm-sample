package com.tracebucket.crm.service.impl;

import com.tracebucket.common.domain.*;
import com.tracebucket.crm.service.OrganizationService;
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

    @Override
    public Organization save(Organization organization) {
        return organizationRepository.save(organization);
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
    public void addBaseCurrency(Currency baseCurrency, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.addBaseCurrency(baseCurrency);
            organizationRepository.save(organization);
        }
    }

    @Override
    public void addTimezone(Timezone timezone, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.addTimezone(timezone);
            organizationRepository.save(organization);
        }
    }

    @Override
    public void addOrganizationUnit(OrganizationUnit organizationUnit, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.addOrganizationUnit(organizationUnit);
            organizationRepository.save(organization);
        }
    }

    @Override
    public void addOrganizationUnitBelow(OrganizationUnit organizationUnit, OrganizationUnit parentOrganizationUnit, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.addOrganizationUnitBelow(organizationUnit, parentOrganizationUnit);
            organizationRepository.save(organization);
        }
    }

    @Override
    public void addContactPerson(Person contactPerson, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.addContactPerson(contactPerson);
            organizationRepository.save(organization);
        }
    }

    @Override
    public void setDefaultContactPerson(Person defaultContactPerson, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.setDefaultContactPerson(defaultContactPerson);
            organizationRepository.save(organization);
        }
    }

    @Override
    public void addContactNumber(Phone phone, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.addContactNumber(phone);
            organizationRepository.save(organization);
        }
    }

    @Override
    public void setDefaultContactNumber(Phone defaultContactNumber, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.setDefaultContactNumber(defaultContactNumber);
            organizationRepository.save(organization);
        }
    }

    @Override
    public void addEmail(Email email, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.addEmail(email);
            organizationRepository.save(organization);
        }
    }

    @Override
    public void setDefaultEmail(Email defaultEmail, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.setDefaultEmail(defaultEmail);
            organizationRepository.save(organization);
        }
    }

    @Override
    public void setHeadOffice(Address headOfficeAddress, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.setHeadOffice(headOfficeAddress);
            organizationRepository.save(organization);
        }
    }

    @Override
    public void moveHeadOfficeTo(Address newHeadOfficeAddress, AggregateId organizationAggregateId) {
        Organization organization = organizationRepository.findOne(organizationAggregateId);
        if(organization != null) {
            organization.moveHeadOfficeTo(newHeadOfficeAddress);
            organizationRepository.save(organization);
        }
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
