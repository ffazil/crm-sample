package com.tracebucket.organization.service;

import com.tracebucket.infrastructure.cqrs.support.Command;
import com.tracebucket.organization.rest.command.AddBaseCurrencyCommand;

/**
 * Created by ffl on 12-02-2015.
 */
public interface OrganizationHandler {
    public void onAddBaseCurrency(Command<AddBaseCurrencyCommand> command);
}
