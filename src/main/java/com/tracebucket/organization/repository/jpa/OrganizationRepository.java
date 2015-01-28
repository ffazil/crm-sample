package com.tracebucket.organization.repository.jpa;

import com.tracebucket.infrastructure.ddd.repository.jpa.BaseRepository;
import com.tracebucket.organization.domain.Organization;

import com.tracebucket.infrastructure.ddd.domain.AggregateId;

/**
 * Created by sadath on 13-Jan-15.
 */
public interface OrganizationRepository extends BaseRepository<Organization, AggregateId> {
}