package com.tracebucket.common.service;

import com.tracebucket.infrastructure.ddd.domain.BaseEntity;
import com.tracebucket.infrastructure.ddd.domain.EntityId;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: firoz
 * Date: 12/11/13
 * Time: 6:52 PM
 * To change this template use File | Settings | File Templates.
 */
public interface BaseEntityService<T extends BaseEntity> {
    public T create(T entity);
    public T update(T entity);
    public List<T> saveAll(List<T> tList);
    public List<T> findAll();
    public T findOne(Long id);
    public void deleteAll();
    public void deleteOne(Long id);
    public T suspend(T entity);
    public T findOne(EntityId entityId);
}
