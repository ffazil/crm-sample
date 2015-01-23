package com.tracebucket.infrastructure.ddd.domain;

import com.tracebucket.infrastructure.event.domain.EventHandlerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

/**
 * Created by ffl on 13-01-2015.
 */
@Component
@Scope("singleton")
public class AggregateRootListener {

    @Autowired
    private EventHandlerHelper eventHandlerHelper;

    @PreUpdate
    @PreRemove
    public void publishEvents(BaseAggregateRoot aggregateRoot){
//        eventHandlerHelper.notify(aggregateRoot.getEvents());
    }

    @PrePersist
    public void initAggregateId(BaseAggregateRoot aggregateRoot) {
        aggregateRoot.aggregateId = AggregateId.generate();
//        eventHandlerHelper.notify(aggregateRoot.getEvents());
    }
}
