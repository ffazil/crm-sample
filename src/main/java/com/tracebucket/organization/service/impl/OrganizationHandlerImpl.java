package com.tracebucket.organization.service.impl;

import com.tracebucket.infrastructure.cqrs.annotation.ApplicationService;
import com.tracebucket.infrastructure.cqrs.support.Command;
import com.tracebucket.organization.rest.command.AddBaseCurrencyCommand;
import com.tracebucket.organization.service.OrganizationHandler;
import com.tracebucket.organization.service.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import reactor.spring.context.annotation.Selector;

/**
 * @author FFL
 * @since 12-02-2015
 * An application service is a command handler in CQRS.
 */
@ApplicationService
public class OrganizationHandlerImpl implements OrganizationHandler{
    private static Logger log = LoggerFactory.getLogger(OrganizationHandlerImpl.class);

    @Autowired
    private OrganizationService organizationService;

    @Selector(value = "Command|addBaseCurrency", reactor = "@commandBus")
    public void onAddBaseCurrency(Command<AddBaseCurrencyCommand> command){
        log.info("Received command " + command.toString());
        AddBaseCurrencyCommand baseCurrencyCommand = command.getData();
        log.info(command.getData().getOrganizationAggregateId());
    }
}
