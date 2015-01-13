package com.tracebucket.crm.test.repository;

import com.tracebucket.crm.test.config.ApplicationTestConfig;
import com.tracebucket.crm.test.config.JPATestConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by sadath on 13-Jan-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes  = {ApplicationTestConfig.class, JPATestConfig.class})
public class OrganizationRepositoryTest {

}