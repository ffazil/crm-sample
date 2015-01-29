package com.tracebucket.crm.test.repository;

import org.junit.After;

/**
 * Created by vishwa on 13-01-2015.
 */

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes  = {ApplicationTestConfig.class, JPATestConfig.class})
@Transactional*/
public class PartnerRepositoryTest {

/*    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    private Partner partner = null;

    private Organization organization = null;

    @Before
    public void setUp() throws Exception{

    }

  /*  private void createPartner() throws Exception{
        partner = PartnerFixture.allRoles();
        organization = organizationRepository.save(partner.getOwner());
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
*/
  /*  @Test
    @Rollback(false)
    public void testFindById() throws Exception {
        createPartner();
        partner = partnerRepository.findOne(partner.getAggregateId());
        Assert.assertNotNull(partner);
    }*/

    @After
    public void tearDown(){
/*        if(partner != null && partner.getAggregateId() != null) {
            partnerRepository.delete(partner.getAggregateId());
            partner = partnerRepository.findOne(partner.getAggregateId());
            Assert.assertNull(partner);
        }
        if(organization != null && organization.getAggregateId() != null) {
            organizationRepository.delete(organization.getAggregateId());
            organization = organizationRepository.findOne(organization.getAggregateId());
            Assert.assertNull(organization);
        }*/
    }

   /* @Test
    @Rollback(false)
    public void testCreate() throws Exception{
        createPartner();
        Assert.assertNotNull(partner.getAggregateId());
    }*/

}
