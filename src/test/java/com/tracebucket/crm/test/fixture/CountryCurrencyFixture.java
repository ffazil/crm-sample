package com.tracebucket.crm.test.fixture;

import com.tracebucket.common.dictionary.CurrencyType;
import com.tracebucket.common.domain.CountryCurrency;
import com.tracebucket.crm.test.builder.CountryCurrencyBuilder;

/**
 * Created by sadath on 27-Nov-14.
 */
public class CountryCurrencyFixture {
    public static CountryCurrency standardCountryCurrency() {
        CountryCurrency countryCurrency = CountryCurrencyBuilder.aCountryCurrencyBuilder()
                .withCurrency(CurrencyFixture.standardCurrency())
                .withCurrencyType(CurrencyType.DEFAULT)
                .build();
        return countryCurrency;
    }

    public static CountryCurrency standardCountryCurrency2() {
        CountryCurrency countryCurrency = CountryCurrencyBuilder.aCountryCurrencyBuilder()
                .withCurrency(CurrencyFixture.standardCurrency2())
                .withCurrencyType(CurrencyType.OPTIONAL)
                .build();
        return countryCurrency;
    }
}
