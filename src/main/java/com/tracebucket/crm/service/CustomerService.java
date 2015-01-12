package com.tracebucket.crm.service;

import com.tracebucket.crm.comand.ChangeCustomerStatusCommand;
import com.tracebucket.crm.domain.Customer;
import com.tracebucket.infrastructure.cqrs.support.Command;

/**
 * Created by ffl on 07-01-2015.
 */
public interface CustomerService {
    public Customer changeStatus(Command<ChangeCustomerStatusCommand> statusCommand);
    public Customer findById(String id);
}
