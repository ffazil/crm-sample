package com.tracebucket.crm.repository.jpa;

import com.tracebucket.aggregates.partner.Partner;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;
import com.tracebucket.infrastructure.ddd.repository.jpa.BaseJpaRepository;

public interface PartnerRepository extends BaseJpaRepository<Partner, AggregateId> {
}
