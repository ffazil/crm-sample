package com.tracebucket.partner.repository.jpa;

import com.tracebucket.partner.domain.Partner;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;
import com.tracebucket.infrastructure.ddd.repository.jpa.BaseJpaRepository;

public interface PartnerRepository extends BaseJpaRepository<Partner, AggregateId> {
}
