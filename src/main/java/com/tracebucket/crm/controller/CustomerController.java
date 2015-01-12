package com.tracebucket.crm.controller;

import com.tracebucket.crm.comand.ChangeCustomerStatusCommand;
import com.tracebucket.crm.domain.Customer;
import com.tracebucket.crm.resource.CustomerResource;
import com.tracebucket.crm.service.CustomerService;
import com.tracebucket.infrastructure.cqrs.support.Command;
import com.tracebucket.infrastructure.cqrs.support.CommandControllerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import reactor.core.Reactor;

/**
 * Created by ffl on 07-01-2015.
 */
@Controller
public class CustomerController {

    @Autowired
    private Reactor commandBus;

    @Autowired
    private CommandControllerHelper commandControllerHelper;

    @Autowired
    private CustomerService customerService;


    @RequestMapping(value = "/customer/status", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public DeferredResult<CustomerResource> changeCustomerStatus(@RequestBody ChangeCustomerStatusCommand command){
        DeferredResult<CustomerResource> deferredResult = new DeferredResult<CustomerResource>();
        commandControllerHelper.intent(Command.name("changeCustomerStatus"), command, deferredResult);
        return deferredResult;

    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ResponseEntity<String> test(){
        return new ResponseEntity<String>("Test", HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<CustomerResource> findById(@PathVariable("id") String id){
        Customer customer = customerService.findById(id);
        return null;
    }



}
