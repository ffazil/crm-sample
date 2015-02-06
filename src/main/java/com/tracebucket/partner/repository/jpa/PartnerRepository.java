package com.tracebucket.partner.repository.jpa;

import com.tracebucket.infrastructure.ddd.repository.jpa.BaseAggregateRepository;
import com.tracebucket.partner.domain.Partner;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;

public interface PartnerRepository extends BaseAggregateRepository<Partner, AggregateId> {
}
