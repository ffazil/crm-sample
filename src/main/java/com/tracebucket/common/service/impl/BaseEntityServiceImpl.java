package com.tracebucket.common.service.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.tracebucket.common.service.BaseEntityService;
import com.tracebucket.exception.DuplicateEntityException;
import com.tracebucket.infrastructure.ddd.domain.BaseEntity;
import com.tracebucket.infrastructure.ddd.domain.EntityId;
import com.tracebucket.infrastructure.ddd.repository.jpa.BaseEntityRepository;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created with IntelliJ IDEA.
 * User: firoz
 * Date: 12/11/13
 * Time: 6:59 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseEntityServiceImpl<T extends BaseEntity> implements BaseEntityService<T> {

    private static Logger log = LoggerFactory.getLogger(BaseEntityServiceImpl.class);

    private final Class< T > clazz;

    @Autowired
    private Mapper mapper;

    public BaseEntityServiceImpl(final Class<T> clazzToSet){
        Preconditions.checkNotNull(clazzToSet);
        clazz = clazzToSet;
    }

    @Override
    public T create(T entity){
        if(entity != null && entity.getEntityId() == null) {
            return getDao().save(entity);
        } else {
            T existingEntity = getDao().findByEntityId(entity.getEntityId());
            if (existingEntity == null) {
                existingEntity = getDao().save(entity);
                return existingEntity;
            } else
                throw new DuplicateEntityException();
        }
    }

    @Override
    public T update(T entity){
        if(entity.getEntityId() != null) {
            T target = getDao().findByEntityId(entity.getEntityId());
            EntityId id = target.getEntityId();

            target = mapper.map(entity, clazz);
            target.setEntityId(id);

            target = getDao().save(target);
            return target;
        }
        else{
            T target = getDao().save(entity);
            return target;
        }
    }

    @Override
    public List<T> findAll() {
        List<T> targets = Lists.newArrayList(getDao().findAll());
        return targets;
    }

    @Override
    public T findOne(Long uid) {
        T target = getDao().findOne(uid);
        return target;
    }

    @Override
    public T findOne(EntityId entityId) {
        T target = getDao().findByEntityId(entityId);
        return target;
    }

    @Override
    public void deleteAll(){
        getDao().deleteAll();
    }

    @Override
    public void deleteOne(Long uid){
        getDao().delete(getDao().findOne(uid));
    }

    @Override
    public void deleteOne(String uuid){
        getDao().delete(getDao().findByEntityId(new EntityId(uuid)));
    }

    @Override
    public T suspend(T entity){
        return entity;
    }

    @Override
    public List<T> saveAll(List<T> tList){

        List<T> list = toList(getDao().save(tList));
        return list;

    }

    public <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }



    protected abstract BaseEntityRepository<T, Long> getDao();
}
