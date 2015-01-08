package com.tracebucket.crm.repository.jpa;

import com.tracebucket.crm.domain.Customer;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;
import com.tracebucket.infrastructure.ddd.repository.jpa.BaseJpaRepository;

/**
 * Created by ffl on 08-01-2015.
 */
public interface CustomerRepository extends BaseJpaRepository<Customer, AggregateId> {
}
