package com.tracebucket.partner.repository.jpa;

import com.tracebucket.partner.domain.Partner;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;

public interface PartnerRepository extends org.springframework.data.jpa.repository.JpaRepository<Partner, AggregateId> {
}
