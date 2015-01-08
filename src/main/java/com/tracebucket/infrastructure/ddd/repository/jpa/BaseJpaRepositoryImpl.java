package com.tracebucket.infrastructure.ddd.repository.jpa;

import com.tracebucket.infrastructure.ddd.domain.AggregateId;
import com.tracebucket.infrastructure.ddd.domain.BaseAggregateRoot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ffl on 07-01-2015.
 */
@SuppressWarnings("unchecked")
@NoRepositoryBean
public class BaseJpaRepositoryImpl<T extends BaseAggregateRoot, ID extends AggregateId> extends SimpleJpaRepository<T, ID> implements BaseJpaRepository<T, ID>{

    private static final long serialVersionUID = 1L;

    static Logger logger = LoggerFactory.getLogger(BaseJpaRepositoryImpl.class);


    private final JpaEntityInformation<T, ?> entityInformation;
    private final EntityManager em;
    private final DefaultPersistenceProvider provider;

    private  Class<?> springDataRepositoryInterface;
    public Class<?> getSpringDataRepositoryInterface() {
        return springDataRepositoryInterface;
    }

    public void setSpringDataRepositoryInterface(
            Class<?> springDataRepositoryInterface) {
        this.springDataRepositoryInterface = springDataRepositoryInterface;
    }

    /**
     * Creates a new {@link SimpleJpaRepository} to manage objects of the given
     * {@link JpaEntityInformation}.
     *
     * @param entityInformation
     * @param entityManager
     */
    public BaseJpaRepositoryImpl (JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager , Class<?> springDataRepositoryInterface) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.em = entityManager;
        this.provider = DefaultPersistenceProvider.fromEntityManager(entityManager);
        this.springDataRepositoryInterface = springDataRepositoryInterface;
    }

    /**
     * Creates a new {@link SimpleJpaRepository} to manage objects of the given
     * domain type.
     *
     * @param domainClass
     * @param em
     */
    public BaseJpaRepositoryImpl(Class<T> domainClass, EntityManager em) {
        this(JpaEntityInformationSupport.getMetadata(domainClass, em), em, null);
    }

    public <S extends T> S save(S entity)
    {
        if (this.entityInformation.isNew(entity)) {
            this.em.persist(entity);
            flush();
            return entity;
        }
        entity = this.em.merge(entity);
        flush();
        return entity;
    }


    public T saveWithoutFlush(T entity)
    {
        return
                super.save(entity);
    }

    public List<T> saveWithoutFlush(Iterable<? extends T> entities)
    {
        List<T> result = new ArrayList<T>();
        if (entities == null) {
            return result;
        }

        for (T entity : entities) {
            result.add(saveWithoutFlush(entity));
        }
        return result;
    }

    @Override
    public T load(ID id) {
        T aggregate = em.find(entityInformation.getJavaType(), id, LockModeType.OPTIMISTIC);

        if (aggregate == null)
            throw new RuntimeException("Aggregate " + (entityInformation.getJavaType().getCanonicalName() + " id = " + id + " does not exist"));

        if (aggregate.isRemoved())
            throw new RuntimeException("Aggregate + " + id + " is removed.");

//        spring.autowireBean(aggregate);

        return aggregate;
    }

    @Override
    public void persist(T aggregate) {
        if (em.contains(aggregate)){
            //locking Aggregate Root logically protects whole aggregate
            em.lock(aggregate, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        }
        else{
            em.persist(aggregate);
        }
    }

    @Override
    public void remove(ID id) {
        T entity = load(id);
        //just flag
        entity.markAsRemoved();
    }
}
