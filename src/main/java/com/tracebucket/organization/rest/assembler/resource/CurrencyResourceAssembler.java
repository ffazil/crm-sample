package com.tracebucket.organization.rest.assembler.resource;

import com.tracebucket.common.domain.Currency;
import com.tracebucket.organization.rest.resource.CurrencyResource;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * Created by sadath on 10-Feb-15.
 */
public class CurrencyResourceAssembler {
    public static CurrencyResource toResource(Currency currency) {
        Mapper mapper = new DozerBeanMapper();
        CurrencyResource currencyResource = new CurrencyResource();
        mapper.map(currency, currencyResource);
        return currencyResource;
    }
}