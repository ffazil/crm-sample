package com.tracebucket.organization.rest.controller;

import com.tracebucket.infrastructure.cqrs.annotation.CommandMapping;
import com.tracebucket.infrastructure.cqrs.annotation.QueryMapping;
import com.tracebucket.infrastructure.cqrs.support.Command;
import com.tracebucket.infrastructure.cqrs.support.CommandWrapper;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;
import com.tracebucket.organization.domain.Organization;
import com.tracebucket.organization.rest.command.AddBaseCurrencyCommand;
import com.tracebucket.organization.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
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

    @CommandMapping(value = "/organization/basecurrency", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, command = "addBaseCurrency")
    public DeferredResult<Organization> addBaseCurrency(@RequestBody  AddBaseCurrencyCommand addBaseCurrencyCommand, CommandWrapper commandWrapper) {
        Command<AddBaseCurrencyCommand> baseCurrencyCommand = Command.wrap(addBaseCurrencyCommand);
        DeferredResult<Organization> deferredResult = new DeferredResult<>();
        commandWrapper.setCommand(baseCurrencyCommand);
        commandWrapper.setDeferredResult(deferredResult);
        return deferredResult;
        //return "forward:/organization/" + addBaseCurrencyCommand.getOrganizationAggregateId();
    }


}
