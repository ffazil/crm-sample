package com.tracebucket.crm.test.repository;

import com.tracebucket.aggregates.partner.Partner;
import com.tracebucket.crm.repository.jpa.PartnerRepository;
import com.tracebucket.crm.test.config.ApplicationTestConfig;
import com.tracebucket.crm.test.config.JPATestConfig;
import com.tracebucket.crm.test.fixture.PartnerFixture;
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
    @Rollback(false)
    public void testCreate() throws Exception{
        createPartner();
        Assert.assertNotNull(partner.getAggregateId());
    }

}
