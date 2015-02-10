package com.tracebucket.organization.rest.assembler.entity;

import com.tracebucket.common.domain.Currency;
import com.tracebucket.organization.rest.resource.CurrencyResource;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * Created by sadath on 10-Feb-15.
 */
public class CurrencyEntityAssembler {
    public static Currency toEntity(CurrencyResource currencyResource) {
        Mapper mapper = new DozerBeanMapper();
        Currency currency = new Currency();
        mapper.map(currencyResource, currency);
        return currency;
    }
}