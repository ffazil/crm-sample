package com.tracebucket.infrastructure.ddd.repository.jpa;

import com.tracebucket.infrastructure.ddd.domain.BaseDomain;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sadath on 28-Jan-15.
 */
@NoRepositoryBean
public class BaseJpaRepositoryImpl<T extends BaseDomain, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseJpaRepository<T, ID> {

    private EntityManager entityManager;

    private JpaEntityInformation<T, ?> entityInformation;

    public BaseJpaRepositoryImpl(final JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.entityManager = entityManager;
    }

    public BaseJpaRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void delete(ID id) {
        Assert.notNull(id, "The given id must not be null!");
        T entity = findOne(id);
        if(entity != null) {
            entity.setPassive(true);
            save(entity);
        }
    }

    @Override
    @Transactional
    public void delete(T entity) {
        Assert.notNull(entity, "The entity must not be null!");
        entity = entityManager.contains(entity) ? entity : entityManager.merge(entity);
        if(entity != null) {
            entity.setPassive(true);
            save(entity);
        }
    }

/*    @Transactional(propagation = Propagation.SUPPORTS)
    public <S extends T> S save(S entity) {
        if (entityInformation.isNew(entity)) {
            entityManager.persist(entity);
            return entity;
        } else {
            return entityManager.merge(entity);
        }
    }*/

    @Override
    /*@Transactional(propagation = Propagation.SUPPORTS)*/
    public T findOne(ID id) {
        T aggregate = entityManager.find(entityInformation.getJavaType(), id, LockModeType.OPTIMISTIC);
        if (aggregate != null && aggregate.isPassive())
            return null;
        return aggregate;
    }

}