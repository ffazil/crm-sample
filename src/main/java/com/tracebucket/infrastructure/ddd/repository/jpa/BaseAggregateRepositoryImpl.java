package com.tracebucket.infrastructure.ddd.repository.jpa;

import com.tracebucket.infrastructure.ddd.domain.BaseAggregateRoot;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import java.io.Serializable;

/**
 * Created by sadath on 28-Jan-15.
 */
@NoRepositoryBean
public class BaseAggregateRepositoryImpl<T extends BaseAggregateRoot, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseAggregateRepository<T, ID> {

    private EntityManager entityManager;

    private JpaEntityInformation<T, ?> entityInformation;

    public BaseAggregateRepositoryImpl(final JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.entityManager = entityManager;
    }

    public BaseAggregateRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
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

    @Override
    public T findOne(ID id) {
        T aggregate = entityManager.find(entityInformation.getJavaType(), id, LockModeType.OPTIMISTIC);
        if (aggregate != null && aggregate.isPassive())
            return null;
        return aggregate;
    }

    @Transactional
    @Override
    public <S extends T> S save(S aggregate) {
        if (entityManager.contains(aggregate)){
            //locking Aggregate Root logically protects whole aggregate
            entityManager.lock(aggregate, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        }
        else{
            entityManager.persist(aggregate);
        }
        return aggregate;
    }



}