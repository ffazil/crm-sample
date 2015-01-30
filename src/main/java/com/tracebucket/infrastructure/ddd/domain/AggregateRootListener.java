package com.tracebucket.infrastructure.ddd.domain;

import com.tracebucket.infrastructure.event.domain.EventHandlerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by ffl on 13-01-2015.
 */
@Configurable
public class AggregateRootListener extends AuditingEntityListener {
    private static Logger log = LoggerFactory.getLogger(AggregateRootListener.class);

    @Autowired
    private EventHandlerHelper eventHandlerHelper;

    @PostPersist
    @PostUpdate
    public void publishEvents(BaseAggregateRoot aggregateRoot){
        log.info(aggregateRoot.getEvents().toString());
        aggregateRoot.getEvents().stream()
                .forEach(event -> {
                    eventHandlerHelper.notify(event, aggregateRoot);
                    log.info("Publishing " + event + " " + aggregateRoot.toString());
                });
    }

    @PrePersist
    public void init(BaseAggregateRoot aggregateRoot){
        /*if(aggregateRoot.getAggregateId() == null){
            aggregateRoot.aggregateId = AggregateId.generate();

        }*/
    }


}
