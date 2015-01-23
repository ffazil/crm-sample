package com.tracebucket.crm.test.repository;

import com.tracebucket.common.dictionary.AddressType;
import com.tracebucket.common.domain.*;
import com.tracebucket.crm.test.config.JPATestConfig;
import com.tracebucket.crm.test.fixture.*;
import com.tracebucket.organization.domain.Organization;
import com.tracebucket.organization.domain.OrganizationUnit;
import com.tracebucket.organization.repository.jpa.OrganizationRepository;
import com.tracebucket.crm.test.config.ApplicationTestConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by sadath on 13-Jan-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes  = {ApplicationTestConfig.class, JPATestConfig.class})
public class OrganizationRepositoryTest {
    @Autowired
    private OrganizationRepository organizationRepository;

    private Organization organization = null;

    @Before
    public void setUp() throws Exception{

    }

    private void createOrganization() throws Exception{
        organization = OrganizationFixture.standardOrganization();
        organization = organizationRepository.save(organization);
    }

    @Test
    public void testCreate() throws Exception {
        createOrganization();
        Assert.assertNotNull(organization.getAggregateId());
    }

    @Test
    public void testAddBaseCurrency() throws Exception {
        //TODO
/*        createOrganization();
        organization = OrganizationFixture.addBaseCurrency(CurrencyFixture.standardCurrency(), organization);
        organization = organizationRepository.save(organization);
        Assert.assertNotNull(organization.getAggregateId());
        Assert.assertNotNull(organization.getBaseCurrencies());
        Assert.assertEquals(1, organization.getBaseCurrencies().size());*/
    }

    @Test
    public void testAddTimezone() throws Exception {
        createOrganization();
        organization = OrganizationFixture.addTimezone(TimezoneFixture.standardTimezone(), organization);
        organization = organizationRepository.save(organization);
        Assert.assertNotNull(organization);
        Assert.assertNotNull(organization.getTimezones());
        Assert.assertEquals(1, organization.getTimezones().size());
    }

    @Test
    public void testAddOrganizationUnit() throws Exception {
        createOrganization();
        organization = OrganizationFixture.addOrganizationUnit(OrganizationUnitFixture.standardOrganizationUnit(), organization);
        organization = organizationRepository.save(organization);
        Assert.assertNotNull(organization);
        Assert.assertNotNull(organization.getOrganizationUnits());
        Assert.assertEquals(1, organization.getOrganizationUnits().size());
    }

    @Test
    public void testAddOrganizationUnitBelow() throws Exception {
        createOrganization();
        organization = OrganizationFixture.addOrganizationUnit(OrganizationUnitFixture.standardOrganizationUnit(), organization);
        organization = organizationRepository.save(organization);
        Assert.assertNotNull(organization);
        Assert.assertNotNull(organization.getOrganizationUnits());
        Assert.assertEquals(1, organization.getOrganizationUnits().size());
        OrganizationUnit childOrganizationUnit = OrganizationUnitFixture.standardOrganizationUnit();
        OrganizationUnit parentOrganizationUnit = null;
        for(OrganizationUnit organizationUnit : organization.getOrganizationUnits()) {
            parentOrganizationUnit = organizationUnit;
        }
        organization = OrganizationFixture.addOrganizationUnitBelow(childOrganizationUnit, parentOrganizationUnit, organization);
        Assert.assertNotNull(organization);
        Assert.assertNotNull(organization.getOrganizationUnits());
        Assert.assertEquals(1, organization.getOrganizationUnits().size());
        //TODO To be checked with database
    }

    @Test
    public void testAddContactPerson() throws Exception {
        createOrganization();
        organization = OrganizationFixture.addContactPerson(PersonFixture.standardPerson(), organization);
        organization = organizationRepository.save(organization);
        Assert.assertNotNull(organization);
        Assert.assertNotNull(organization.getContactPersons());
        Assert.assertEquals(1, organization.getContactPersons().size());
    }

    @Test
    public void testSetDefaultContactPerson() throws Exception {
        createOrganization();
        organization = OrganizationFixture.addContactPerson(PersonFixture.standardPerson(), organization);
        organization = organizationRepository.save(organization);
        Assert.assertNotNull(organization);
        Assert.assertNotNull(organization.getContactPersons());
        Assert.assertEquals(1, organization.getContactPersons().size());
        //TODO Assert Default Contact Person
    }

    @Test
    public void testAddContactNumber() throws Exception {
        createOrganization();
        organization = OrganizationFixture.addContactNumber(PhoneFixture.standardPhone(), organization);
        organization = organizationRepository.save(organization);
        Assert.assertNotNull(organization);
        Assert.assertNotNull(organization.getPhones());
        Assert.assertEquals(1, organization.getPhones().size());
    }

    @Test
    public void testSetDefaultContactNumber() throws Exception {
        createOrganization();
        organization = OrganizationFixture.addContactNumber(PhoneFixture.standardPhone(), organization);
        organization = organizationRepository.save(organization);
        Assert.assertNotNull(organization);
        Assert.assertNotNull(organization.getPhones());
        Assert.assertEquals(1, organization.getPhones().size());
        //TODO Assert Default Contact Number
    }

    @Test
    public void testAddEmail() throws Exception {
        createOrganization();
        organization = OrganizationFixture.addEmail(EmailFixture.standardEmail(), organization);
        organization = organizationRepository.save(organization);
        Assert.assertNotNull(organization);
        Assert.assertNotNull(organization.getEmails());
        Assert.assertEquals(1, organization.getEmails().size());
    }

    @Test
    public void testSetDefaultEmail() throws Exception {
        createOrganization();
        organization = OrganizationFixture.addEmail(EmailFixture.standardEmail(), organization);
        organization = organizationRepository.save(organization);
        Assert.assertNotNull(organization);
        Assert.assertNotNull(organization.getEmails());
        Assert.assertEquals(1, organization.getEmails().size());
        //TODO Assert Default Email
    }

    @Test
    public void testSetHeadOffice() throws Exception {
        createOrganization();
        organization = OrganizationFixture.setHeadOffice(AddressFixture.headOffice(), organization);
        organization = organizationRepository.save(organization);
        Assert.assertNotNull(organization);
        Assert.assertNotNull(organization.getHeadOfficeAddress());
        Assert.assertEquals(AddressType.HEAD_OFFICE, organization.getHeadOfficeAddress().getAddressType());
    }

    @Test
    public void testMoveHeadOfficeTo() throws Exception {
        createOrganization();
        organization = OrganizationFixture.setHeadOffice(AddressFixture.headOffice(), organization);
        organization = organizationRepository.save(organization);
        Assert.assertNotNull(organization);
        Assert.assertNotNull(organization.getHeadOfficeAddress());
        Assert.assertEquals(AddressType.HEAD_OFFICE, organization.getHeadOfficeAddress().getAddressType());
        //TODO To Be Discussed
    }

    @Test
    public void testGetHeadOfficeAddress() throws Exception {
        createOrganization();
        organization = OrganizationFixture.setHeadOffice(AddressFixture.headOffice(), organization);
        organization = organizationRepository.save(organization);
        Assert.assertNotNull(organization);
        Assert.assertNotNull(organization.getHeadOfficeAddress());
        Assert.assertEquals(AddressType.HEAD_OFFICE, organization.getHeadOfficeAddress().getAddressType());
    }

    @Test
    public void testGetBaseCurrencies() throws Exception {
        //TODO
/*        createOrganization();
        organization = OrganizationFixture.addBaseCurrency(CurrencyFixture.standardCurrency(), organization);
        organization = organizationRepository.save(organization);
        Assert.assertNotNull(organization.getAggregateId());
        Assert.assertNotNull(organization.getBaseCurrencies());
        Assert.assertEquals(1, organization.getBaseCurrencies().size());*/
    }

    @Test
    public void testGetOrganizationUnits() throws Exception {
        createOrganization();
        organization = OrganizationFixture.addOrganizationUnit(OrganizationUnitFixture.standardOrganizationUnit(), organization);
        organization = organizationRepository.save(organization);
        Assert.assertNotNull(organization);
        Assert.assertNotNull(organization.getOrganizationUnits());
        Assert.assertEquals(1, organization.getOrganizationUnits().size());
    }

    @Test
    public void testGetContactNumbers() throws Exception {
        createOrganization();
        organization = OrganizationFixture.addContactNumber(PhoneFixture.standardPhone(), organization);
        organization = organizationRepository.save(organization);
        Assert.assertNotNull(organization);
        Assert.assertNotNull(organization.getPhones());
        Assert.assertEquals(1, organization.getPhones().size());
    }

    @Test
    public void testGetEmails() throws Exception {
        createOrganization();
        organization = OrganizationFixture.addEmail(EmailFixture.standardEmail(), organization);
        organization = organizationRepository.save(organization);
        Assert.assertNotNull(organization);
        Assert.assertNotNull(organization.getEmails());
        Assert.assertEquals(1, organization.getEmails().size());
    }

    @Test
    public void testFindById() throws Exception {
        createOrganization();
        organization = organizationRepository.findOne(organization.getAggregateId());
        Assert.assertNotNull(organization);
    }

    @After
    public void tearDown(){
        if(organization != null && organization.getAggregateId() != null) {
            organizationRepository.delete(organization.getAggregateId());
            organization = organizationRepository.findOne(organization.getAggregateId());
            Assert.assertNull(organization);
        }
    }
}