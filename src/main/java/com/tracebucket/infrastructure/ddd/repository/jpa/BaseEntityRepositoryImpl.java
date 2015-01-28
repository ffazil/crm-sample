package com.tracebucket.infrastructure.ddd.repository.jpa;

import com.tracebucket.exception.CoreException;
import com.tracebucket.infrastructure.ddd.domain.BaseEntity;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by sadath on 28-Jan-15.
 */
@NoRepositoryBean
public class BaseEntityRepositoryImpl<T extends BaseEntity, ID extends Serializable> extends SimpleJpaRepository<T , ID> implements BaseEntityRepository<T, ID> {

    private EntityManager entityManager;

    public BaseEntityRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public BaseEntityRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public boolean deleteEntity(ID id) {
        Assert.notNull(id, "The given id must not be null!");
        T entity = findOne(id);
        Assert.notNull(entity, "Entity with Id : " + id + "doesn't exist");
        entity.setPassive(true);
        entity = save(entity);
        entity = super.findOne((ID) entity.getId());
        return entity != null ? false : true;
    }
}