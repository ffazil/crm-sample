package com.tracebucket.infrastructure.ddd.repository.jpa;

import com.tracebucket.infrastructure.ddd.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by sadath on 06-Feb-15.
 */
@NoRepositoryBean
public interface BaseEntityRepository<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID> {

}