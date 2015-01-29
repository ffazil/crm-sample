package com.tracebucket.crm.repository.jpa;

import com.tracebucket.crm.domain.Customer;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;

/**
 * Created by ffl on 08-01-2015.
 */
public interface CustomerRepository extends org.springframework.data.jpa.repository.JpaRepository<Customer, AggregateId> {
}
