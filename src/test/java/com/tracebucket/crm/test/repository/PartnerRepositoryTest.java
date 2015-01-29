package com.tracebucket.crm.test.repository;

import com.tracebucket.infrastructure.ddd.domain.BaseDomain;
import com.tracebucket.organization.repository.jpa.OrganizationRepository;
import com.tracebucket.partner.domain.Customer;
import com.tracebucket.crm.test.config.JPATestConfig;
import com.tracebucket.crm.test.fixture.CustomerFixture;
import com.tracebucket.crm.test.fixture.OwnerFixture;
import com.tracebucket.organization.domain.Organization;
import com.tracebucket.partner.domain.Owner;
import com.tracebucket.partner.domain.Partner;
import com.tracebucket.partner.domain.PartnerRole;
import com.tracebucket.partner.repository.jpa.PartnerRepository;
import com.tracebucket.crm.test.config.ApplicationTestConfig;
import com.tracebucket.crm.test.fixture.PartnerFixture;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

/**
 * Created by vishwa on 13-01-2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes  = {ApplicationTestConfig.class, JPATestConfig.class})
@Transactional
public class PartnerRepositoryTest {

   @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private OrganizationRepository organizationJpaRepository;

    private Partner partner = null;

    private Organization organization = null;

    private Owner owner = null;

    @Before
    public void setUp() throws Exception{

    }

    private void createPartner() throws Exception{
        partner = PartnerFixture.standardPartner();
        owner = OwnerFixture.standardOwner();
        partner.setOwner(owner);
        //organization = organizationRepository.save(partner.getOwner());
        partner = partnerRepository.save(partner);
    }

    @Test
    @Rollback(false)
    public void testCreate() throws Exception{
        createPartner();
        Assert.assertNotNull(partner.getAggregateId());
    }

    @Test
    public void testUpdate() throws Exception {
        createPartner();

        partner.getAllAssignedRoles().clear();
        partner = partnerRepository.save(partner);
        Assert.assertEquals(0, partner.getAllAssignedRoles().size());
        Customer customer = CustomerFixture.standardCustomer();
        partner.getAllAssignedRoles().add(customer);
        Assert.assertEquals(1, partner.getAllAssignedRoles().size());
    }
    @Test
    @Rollback(false)
    public void testFindById() throws Exception {
        createPartner();
        partner = partnerRepository.findOne(partner.getAggregateId());
        Assert.assertNotNull(partner);
    }
    @After
    public void tearDown(){
        if(partner != null && partner.getAggregateId() != null) {
            partnerRepository.delete(partner.getAggregateId());
            partner = partnerRepository.findOne(partner.getAggregateId());
            Assert.assertTrue(((BaseDomain) partner).isPassive());
        }
        /*if(organization != null && organization.getAggregateId() != null) {
            organizationRepository.delete(organization.getAggregateId());
            organization = organizationRepository.findOne(organization.getAggregateId());
            Assert.assertNull(organization);
        }*/
    }


}
