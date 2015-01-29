package com.tracebucket.crm.test.repository;

import com.tracebucket.crm.test.config.JPATestConfig;
import com.tracebucket.infrastructure.ddd.domain.BaseDomain;
import com.tracebucket.organization.domain.Organization;
import com.tracebucket.organization.repository.jpa.OrganizationRepository;
import com.tracebucket.crm.test.config.ApplicationTestConfig;
import com.tracebucket.crm.test.fixture.AddressFixture;
import com.tracebucket.crm.test.fixture.OrganizationFixture;
import com.tracebucket.crm.test.fixture.PersonFixture;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void testCreate() throws Exception{
        createOrganization();
        Assert.assertNotNull(organization.getAggregateId());
    }

    @Test
    public void testUpdate() throws Exception {
        createOrganization();
        organization.getContactPersons().clear();
        organization.getAddresses().clear();
        organization = organizationRepository.save(organization);
        Assert.assertEquals(0, organization.getContactPersons().size());
        Assert.assertEquals(0, organization.getAddresses().size());
        organization.getContactPersons().add(PersonFixture.standardPerson2());
        organization.getAddresses().add(AddressFixture.headOffice());
        organization = organizationRepository.save(organization);
        Assert.assertEquals(1, organization.getContactPersons().size());
        Assert.assertEquals(1, organization.getAddresses().size());
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
            Assert.assertTrue(((BaseDomain) organization).isPassive());
        }
    }
}