package com.tracebucket.crm.service.impl;

import com.tracebucket.crm.comand.ChangeCustomerStatusCommand;
import com.tracebucket.crm.domain.Customer;
import com.tracebucket.crm.repository.jpa.CustomerRepository;
import com.tracebucket.crm.service.CustomerService;
import com.tracebucket.infrastructure.cqrs.annotation.ApplicationService;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.spring.context.annotation.Selector;

/**
 * Created by ffl on 07-01-2015.
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;




    @Override
    @Selector(value = "Command|changeCustomerStatus", reactor = "@commandBus")
    public Customer changeStatus(ChangeCustomerStatusCommand command) {
        Customer customer = (Customer) customerRepository.load(command.getCustomerId());

        return null;
    }

    @Override
    public Customer findById(String id) {
        Customer customer = customerRepository.load(new AggregateId(id));
        return customer;
    }


}
