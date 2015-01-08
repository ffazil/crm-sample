package com.tracebucket.crm.test.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracebucket.crm.comand.ChangeCustomerStatusCommand;
import com.tracebucket.crm.domain.Customer;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;
import org.junit.Test;

/**
 * Created by ffl on 08-01-2015.
 */
public class ChangeCustomerStatusCommandTest {

    @Test
    public void testCommand() throws JsonProcessingException {
        ChangeCustomerStatusCommand command = new ChangeCustomerStatusCommand(AggregateId.generate(), Customer.CustomerStatus.PLATINUM);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(command));
    }
}
