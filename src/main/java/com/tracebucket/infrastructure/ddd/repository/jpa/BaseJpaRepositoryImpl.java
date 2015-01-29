package com.tracebucket.infrastructure.ddd.repository.jpa;

import com.tracebucket.infrastructure.ddd.domain.BaseDomain;
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
public class BaseJpaRepositoryImpl<T extends BaseDomain, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseJpaRepository<T, ID> {

    private EntityManager entityManager;

    public BaseJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
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
        Assert.notNull(entity, "Entity with Id : " + id + "doesn't exist");
        entity.setPassive(true);
        save(entity);
    }

    @Override
    @Transactional
    public void delete(T entity) {
        Assert.notNull(entity, "The entity must not be null!");
        entity = entityManager.contains(entity) ? entity : entityManager.merge(entity);
        entity.setPassive(true);
        save(entity);
    }
}