package com.tracebucket.crm.repository.jpa;

import com.tracebucket.common.domain.Currency;
import com.tracebucket.infrastructure.ddd.domain.BaseEntity;
import com.tracebucket.infrastructure.ddd.repository.jpa.BaseAggregateRepository;
import com.tracebucket.infrastructure.ddd.repository.jpa.BaseEntityRepository;

/**
 * Created by sadath on 27-Jan-15.
 */
public interface CurrencyRepository extends BaseEntityRepository<Currency, Long> {
}
