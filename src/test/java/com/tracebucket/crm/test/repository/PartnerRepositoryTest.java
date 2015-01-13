package com.tracebucket.crm.test.repository;

import com.tracebucket.aggregates.partner.Partner;
import com.tracebucket.crm.repository.jpa.PartnerRepository;
import com.tracebucket.crm.test.config.ApplicationTestConfig;
import com.tracebucket.crm.test.config.JPATestConfig;
import com.tracebucket.crm.test.fixture.AddressFixture;
import com.tracebucket.crm.test.fixture.CustomerFixture;
import com.tracebucket.crm.test.fixture.PartnerFixture;
import com.tracebucket.crm.test.fixture.PersonFixture;
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
 * Created by vishwa on 13-01-2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes  = {ApplicationTestConfig.class, JPATestConfig.class})
public class PartnerRepositoryTest {

    @Autowired
    private PartnerRepository partnerRepository;

    private Partner partner = null;

    @Before
    public void setUp() throws Exception{

    }

    private void createPartner() throws Exception{
        partner = PartnerFixture.allRoles();
        partner = partnerRepository.save(partner);
    }

    @Test
    public void testUpdate() throws Exception {
        createPartner();
        partner.getPartnerRoles().clear();
        partner = partnerRepository.save(partner);
        Assert.assertEquals(0, partner.getPartnerRoles().size());
        partner.getPartnerRoles().add(CustomerFixture.standardCustomer());
        partner = partnerRepository.save(partner);
        Assert.assertEquals(1, partner.getPartnerRoles().size());
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
        /*if(partner != null && partner.getAggregateId() != null) {
            partnerRepository.delete(partner.getAggregateId());
            partner = partnerRepository.findOne(partner.getAggregateId());
            Assert.assertNull(partner);
        }*/
    }

    @Test
    @Rollback(false)
    public void testCreate() throws Exception{
        createPartner();
        Assert.assertNotNull(partner.getAggregateId());
    }

}
