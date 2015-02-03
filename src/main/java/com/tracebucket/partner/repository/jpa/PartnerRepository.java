package com.tracebucket.partner.repository.jpa;

import com.tracebucket.infrastructure.ddd.repository.jpa.BaseJpaRepository;
import com.tracebucket.partner.domain.Partner;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;

public interface PartnerRepository extends BaseJpaRepository<Partner, AggregateId> {
}
