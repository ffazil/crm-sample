package com.tracebucket.crm.service;

import com.tracebucket.crm.comand.ChangeCustomerStatusCommand;
import com.tracebucket.crm.domain.Customer;

/**
 * Created by ffl on 07-01-2015.
 */
public interface CustomerService {
    public Customer changeStatus(ChangeCustomerStatusCommand command);
    public Customer findById(String id);
}
