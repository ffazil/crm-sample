package com.tracebucket.infrastructure.ddd.repository.jpa;

import com.tracebucket.infrastructure.ddd.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by sadath on 27-Jan-15.
 */
@NoRepositoryBean
public interface BaseEntityRepository<T extends BaseEntity, ID extends Long> extends JpaRepository<T, Long> {
}
