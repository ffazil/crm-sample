package com.tracebucket.infrastructure.ddd.repository.jpa;

import com.tracebucket.infrastructure.ddd.domain.BaseDomain;
import com.tracebucket.infrastructure.ddd.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by sadath on 27-Jan-15.
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseDomain, ID extends Serializable> extends JpaRepository<T, ID> {

}
