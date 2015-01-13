package com.tracebucket.common.domain;

import com.tracebucket.common.dictionary.CurrencyType;
import com.tracebucket.infrastructure.ddd.domain.BaseEntity;

import javax.persistence.*;

/**
 * Created by sadath on 27-Nov-14.
 */
@Entity
@Table(name = "COUNTRY_CURRENCY")
public class CountryCurrency extends BaseEntity {

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "CURRENCY__ID")
    private Currency currency;

    @Column(name = "CURRENCY_TYPE", nullable = false, columnDefinition = "ENUM('DEFAULT', 'OPTIONAL') default 'DEFAULT'")
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }
}
