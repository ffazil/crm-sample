package com.tracebucket.organization.rest.controller;

import com.tracebucket.infrastructure.cqrs.annotation.CommandMapping;
import com.tracebucket.infrastructure.cqrs.annotation.QueryMapping;
import com.tracebucket.infrastructure.cqrs.support.Command;
import com.tracebucket.infrastructure.cqrs.support.CommandWrapper;
import com.tracebucket.organization.rest.command.AddBaseCurrencyCommand;
import com.tracebucket.organization.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import reactor.core.Reactor;

/**
 * Created by sadath on 10-Feb-15.
 */
@Controller
public class OrganizationController {

    @Autowired
    private Reactor commandBus;

    @Autowired
    private OrganizationService organizationService;

    @CommandMapping(value = "/organization/basecurrency", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, commandBus = "@commandBus")
    public String addBaseCurrency(@RequestBody  AddBaseCurrencyCommand addBaseCurrencyCommand, CommandWrapper commandWrapper) {
        Command<AddBaseCurrencyCommand> baseCurrencyCommand = Command.wrap(addBaseCurrencyCommand);
        commandWrapper.setCommand(baseCurrencyCommand);
        return "forward:/organization/" + addBaseCurrencyCommand.getOrganizationAggregateId();
    }

    @QueryMapping(value = "/organization/{uid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOrganization(@PathVariable("uid") String uid){
        return "test";
    }
}
