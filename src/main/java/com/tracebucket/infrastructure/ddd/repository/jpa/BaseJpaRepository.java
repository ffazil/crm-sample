package com.tracebucket.infrastructure.ddd.repository.jpa;

import com.tracebucket.infrastructure.ddd.domain.AggregateId;
import com.tracebucket.infrastructure.ddd.domain.BaseAggregateRoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by ffl on 07-01-2015.
 */
@NoRepositoryBean
public interface BaseJpaRepository<T extends BaseAggregateRoot, ID extends AggregateId> extends JpaRepository<T, ID>{

}
