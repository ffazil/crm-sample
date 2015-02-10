package com.tracebucket.organization.rest.command;

import com.tracebucket.organization.rest.resource.CurrencyResource;

/**
 * Created by sadath on 10-Feb-15.
 */
public class AddBaseCurrencyCommand {
    private String organizationAggregateId;
    private CurrencyResource currencyResource;

    public String getOrganizationAggregateId() {
        return organizationAggregateId;
    }

    public void setOrganizationAggregateId(String organizationAggregateId) {
        this.organizationAggregateId = organizationAggregateId;
    }

    public CurrencyResource getCurrencyResource() {
        return currencyResource;
    }

    public void setCurrencyResource(CurrencyResource currencyResource) {
        this.currencyResource = currencyResource;
    }
}
