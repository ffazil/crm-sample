package com.tracebucket.crm.repository.jpa;

import com.tracebucket.infrastructure.ddd.domain.AggregateId;
import com.tracebucket.infrastructure.ddd.repository.jpa.BaseJpaRepository;
import com.tracebucket.aggregates.organization.Organization;

/**
 * Created by sadath on 13-Jan-15.
 */
public interface OrganizationRepository extends BaseJpaRepository<Organization, AggregateId> {
}
