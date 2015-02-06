package com.tracebucket.infrastructure.ddd.repository.jpa;

import com.tracebucket.infrastructure.ddd.domain.BaseAggregateRoot;
import com.tracebucket.infrastructure.ddd.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by sadath on 27-Jan-15.
 */
@NoRepositoryBean
public interface BaseAggregateRepository<T extends BaseAggregateRoot, ID extends Serializable> extends JpaRepository<T, ID> {

}