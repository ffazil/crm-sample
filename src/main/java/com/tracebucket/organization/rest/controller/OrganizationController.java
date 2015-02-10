package com.tracebucket.organization.rest.controller;

import com.tracebucket.common.domain.Currency;
import com.tracebucket.infrastructure.cqrs.annotation.Command;
import com.tracebucket.infrastructure.cqrs.annotation.CommandMapping;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;
import com.tracebucket.organization.domain.Organization;
import com.tracebucket.organization.rest.assembler.entity.CurrencyEntityAssembler;
import com.tracebucket.organization.rest.command.AddBaseCurrencyCommand;
import com.tracebucket.organization.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactor.core.Reactor;

import java.util.Set;

/**
 * Created by sadath on 10-Feb-15.
 */
@Controller
public class OrganizationController {

    @Autowired
    private Reactor commandBus;

    @Autowired
    private OrganizationService organizationService;

    @CommandMapping(value = "/organization/basecurrency", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, commandBus = "@commandBus")
    public ResponseEntity<Set<Currency>> addBaseCurrency(@RequestBody  AddBaseCurrencyCommand addBaseCurrencyCommand) {
        return new ResponseEntity<Set<Currency>>(organizationService.addBaseCurrency(CurrencyEntityAssembler.toEntity(addBaseCurrencyCommand.getCurrencyResource()), new AggregateId(addBaseCurrencyCommand.getOrganizationAggregateId())).getBaseCurrencies(), HttpStatus.OK);
    }
}
