package com.tracebucket.crm.test.repository;

import com.tracebucket.crm.repository.jpa.OrganizationRepository;
import com.tracebucket.crm.test.config.ApplicationTestConfig;
import com.tracebucket.crm.test.config.JPATestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by sadath on 13-Jan-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes  = {ApplicationTestConfig.class, JPATestConfig.class})
public class OrganizationRepositoryTest {
    private static Logger log = LoggerFactory.getLogger(OrganizationRepositoryTest.class);

    @Autowired
    private OrganizationRepository organizationRepository;

    @Before
    public void setUp(){

    }

    @Test
    public void testCreate(){

    }
}