package com.tracebucket.crm.service.impl;

import com.tracebucket.common.domain.Currency;
import com.tracebucket.crm.repository.jpa.CurrencyRepository;
import com.tracebucket.crm.service.CurrencyService;
import com.tracebucket.infrastructure.ddd.repository.jpa.BaseJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sadath on 27-Jan-15.
 */
@Service
@Transactional
public class CurrencyServiceImpl extends BaseEntityServiceImpl<Currency> implements CurrencyService {

    private static final Logger log = LoggerFactory.getLogger(CurrencyServiceImpl.class);

    @Autowired
    private CurrencyRepository currencyRepository;

    public CurrencyServiceImpl() {
        super(Currency.class);
    }

    @Override
    protected BaseJpaRepository<Currency, Long> getDao() {
        return currencyRepository;
    }
}
