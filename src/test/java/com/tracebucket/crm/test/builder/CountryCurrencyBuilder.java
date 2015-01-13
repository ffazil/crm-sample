package com.tracebucket.crm.test.builder;

import com.tracebucket.common.dictionary.CurrencyType;
import com.tracebucket.common.domain.CountryCurrency;
import com.tracebucket.common.domain.Currency;

/**
 * Created by sadath on 27-Nov-14.
 */
public class CountryCurrencyBuilder {
    private Currency currency;
    private CurrencyType currencyType;

    private CountryCurrencyBuilder(){ }

    public static CountryCurrencyBuilder aCountryCurrencyBuilder(){
        return new CountryCurrencyBuilder();
    }

    public CountryCurrencyBuilder withCurrency(Currency currency){
        this.currency = currency;
        return this;
    }

    public CountryCurrencyBuilder withCurrencyType(CurrencyType currencyType){
        this.currencyType = currencyType;
        return this;
    }

    public CountryCurrency build(){
        CountryCurrency countryCurrency = new CountryCurrency();
        countryCurrency.setCurrency(currency);
        countryCurrency.setCurrencyType(currencyType);
        return countryCurrency;
    }

}
