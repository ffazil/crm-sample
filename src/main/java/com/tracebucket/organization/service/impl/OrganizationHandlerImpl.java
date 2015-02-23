package com.tracebucket.organization.service.impl;

import com.tracebucket.common.domain.Currency;
import com.tracebucket.common.repository.jpa.CurrencyRepository;
import com.tracebucket.infrastructure.cqrs.annotation.ApplicationService;
import com.tracebucket.infrastructure.cqrs.support.Command;
import com.tracebucket.infrastructure.cqrs.annotation.CommandHandler;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;
import com.tracebucket.infrastructure.ddd.domain.EntityId;
import com.tracebucket.organization.domain.Organization;
import com.tracebucket.organization.rest.command.AddBaseCurrencyCommand;
import com.tracebucket.organization.service.OrganizationHandler;
import com.tracebucket.organization.service.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    private CurrencyRepository currencyRepository;

    @CommandHandler(value = "Command|addBaseCurrency", reactor = "@commandBus")
    public Organization onAddBaseCurrency(Command<AddBaseCurrencyCommand> command){
        log.info("Received command " + command.toString());
        AddBaseCurrencyCommand baseCurrencyCommand = command.getData();
        Currency currency = currencyRepository.findByEntityId(new EntityId(baseCurrencyCommand.getCurrencyId()));
        Organization organization = organizationService.addBaseCurrency(currency, new AggregateId(baseCurrencyCommand.getOrganizationAggregateId()));
        return organization;
    }
}
