package com.tracebucket.crm.test.fixture;

import com.tracebucket.common.domain.Currency;
import com.tracebucket.crm.test.builder.CurrencyBuilder;

import java.util.Date;

/**
 * Created by sadath on 24-Nov-14.
 */
public class CurrencyFixture {
    public static Currency standardCurrency() {
        Currency currency = CurrencyBuilder.aCurrencyBuilder()
                .withName("EUR " + new Date().getTime())
                .withImage("image")
                .withIso4217Code("ISO CODE " + new Date().getTime())
                .withSubUnit110("SUB UNIT " + new Date().getTime())
                .build();
        return currency;
    }

    public static Currency standardCurrency2() {
        Currency currency = CurrencyBuilder.aCurrencyBuilder()
                .withName("INR " + new Date().getTime())
                .withImage("image")
                .withIso4217Code("ISO CODE " + new Date().getTime())
                .withSubUnit110("SUB UNIT " + new Date().getTime())
                .build();
        return currency;
    }
}
