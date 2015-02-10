package com.tracebucket.crm.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracebucket.common.domain.Currency;
import com.tracebucket.crm.service.CurrencyService;
import com.tracebucket.crm.test.config.*;
import com.tracebucket.crm.test.fixture.CurrencyFixture;
import com.tracebucket.crm.test.fixture.OrganizationFixture;
import com.tracebucket.organization.domain.Organization;
import com.tracebucket.organization.service.OrganizationService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by sadath on 10-Feb-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes  = {ApplicationTestConfig.class, ServiceTestConfig.class, JPATestConfig.class, InfrastructureTestConfig.class, WebTestConfig.class})
public class OrganizationControllerTest {

    private static final Logger log = LoggerFactory.getLogger(OrganizationControllerTest.class);

    private static MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private CurrencyService currencyService;

    private Organization organization = null;

    private Currency currency = null;

    @Before
    public void setUp(){
        mockMvc = webAppContextSetup(this.wac).build();
    }

    private void createOrganization() throws Exception{
        organization = OrganizationFixture.standardOrganization();
        organization = organizationService.save(organization);
    }

    @Test
    public void testCreate() throws Exception {
        createOrganization();
        Assert.assertNotNull(organization.getAggregateId());
    }

    @Test
    public void testAddBaseCurrency() throws Exception{

        createOrganization();
        currency = CurrencyFixture.standardCurrency();
        currency = currencyService.create(currency);
        Assert.assertNotNull(currency);


        MvcResult mvcResult = null;
        log.info("Add Base Currency : "+ objectMapper.writeValueAsString(currency));
        mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.put("/organization/basecurrency/"+organization.getAggregateId())
                        .content(objectMapper.writeValueAsString(currency))
                        .contentType(org.springframework.http.MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        log.info("Organization after base currency added: "+mvcResult.getResponse().getContentAsString());
    }

/*    @After
    public void tearDown(){
        if(organization != null && organization.getAggregateId() != null) {
            organizationService.delete(organization.getAggregateId());
            organization = organizationService.findOne(organization.getAggregateId());
            Assert.assertNull(organization);
        }
        if(currency != null && currency.getId() != null) {
            currencyService.deleteOne(currency.getId());
            currency = currencyService.findOne(currency.getId());
            Assert.assertNull(currency);
        }
    }*/

}