package com.tracebucket.crm.test.service;

import com.tracebucket.common.dictionary.PartnerCategory;
import com.tracebucket.crm.service.CurrencyService;
import com.tracebucket.crm.service.PartnerService;
import com.tracebucket.crm.test.config.ApplicationTestConfig;
import com.tracebucket.crm.test.config.InfrastructureTestConfig;
import com.tracebucket.crm.test.config.JPATestConfig;
import com.tracebucket.crm.test.config.ServiceTestConfig;
import com.tracebucket.crm.test.fixture.AddressFixture;
import com.tracebucket.crm.test.fixture.CustomerFixture;
import com.tracebucket.crm.test.fixture.OwnerFixture;
import com.tracebucket.crm.test.fixture.PartnerFixture;
import com.tracebucket.infrastructure.ddd.domain.BaseDomain;
import com.tracebucket.partner.domain.Customer;
import com.tracebucket.partner.domain.Owner;
import com.tracebucket.partner.domain.Partner;
import com.tracebucket.partner.domain.PartnerRole;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

/**
 * Created by vishwa on 28-01-2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes  = {ApplicationTestConfig.class, JPATestConfig.class, ServiceTestConfig.class, InfrastructureTestConfig.class})
public class PartnerServiceTest {

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private CurrencyService currencyService;

    private Partner partner = null;

    private Owner owner = null;

    @Before
    public void setUp() {

    }

    private void createPartner() {
        try {
            partner = PartnerFixture.standardPartner();
            partner = partnerService.save(partner);
            owner = OwnerFixture.standardOwner();
            partner.setOwner(owner);
            partner = partnerService.save(partner);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreate()  {
        createPartner();
        Assert.assertNotNull(partner);
        Assert.assertNotNull(partner.getAggregateId());
    }

    @Test
    public void testSetPartnerCategory() {
        createPartner();
        if(partner != null) {
            partner = partnerService.setPartnerCategory(PartnerCategory.ORGANIZATION, partner.getAggregateId());
            Assert.assertNotNull(partner);
            Assert.assertEquals(partner.getPartnerCategory(), PartnerCategory.ORGANIZATION);
        }
    }

    @Test
    public void testAddPartnerRole() {
        createPartner();
        if(partner != null) {
            partner = partnerService.addPartnerRole(CustomerFixture.standardCustomer(), partner.getAggregateId());
            Assert.assertNotNull(partner);
            Assert.assertNotNull(partner.getAllAssignedRoles());
            Assert.assertEquals(1, partner.getAllAssignedRoles().size());
        }
    }

    @Test
    public void testAddAddressToRole() {
        createPartner();
        if(partner != null) {
            partner = partnerService.addAddressToRole(CustomerFixture.standardCustomer(), AddressFixture.standardAddress(), partner.getAggregateId());
            Assert.assertNotNull(partner);
            Assert.assertNotNull(partner.getAllAssignedRoles());
            for (PartnerRole partnerRole : partner.getAllAssignedRoles()) {
                Assert.assertEquals(1, partnerRole.getAddresses().size());
                break;
            }
        }
    }

    @Test
    public void testChangeOwner() {
        createPartner();
        if(partner != null) {
            Owner owner = OwnerFixture.standardOwner2();
            partner = partnerService.changeOwner(owner, partner.getAggregateId());
            Assert.assertNotNull(partner);
            Assert.assertEquals(partner.getOwner().getName(), owner.getName());
        }
    }

    @Test
    public void testHasPartnerRole() {
        createPartner();
        if(partner != null) {
            Customer customer = CustomerFixture.standardCustomer();
            partner = partnerService.addPartnerRole(customer, partner.getAggregateId());
            for (PartnerRole partnerRole : partner.getAllAssignedRoles()) {
                if (partnerRole instanceof Customer) {
                    Assert.assertTrue(partnerService.hasPartnerRole(partnerRole, partner.getAggregateId()));
                }
            }
        }
    }

    @Test
    public void testFindById()  {
        createPartner();
        if(partner != null) {
            partner = partnerService.findOne(partner.getAggregateId());
            Assert.assertNotNull(partner);
        }
    }

    @After
    public void tearDown(){
        if(partner != null && partner.getAggregateId() != null) {
            partnerService.delete(partner.getAggregateId());
            partner = partnerService.findOne(partner.getAggregateId());
            Assert.assertNull(partner);
        }
/*        if(owner != null ) {
            currencyService.deleteOne(currency.getId());
            currency = currencyService.findOne(currency.getId());
            Assert.assertNull(currency);
        }*/
    }

/*    @AfterClass
    public static void cleanup(){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
}
