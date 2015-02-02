package com.tracebucket.infrastructure.ddd.support;

import com.tracebucket.infrastructure.ddd.domain.BaseAggregateRoot;
import com.tracebucket.infrastructure.ddd.domain.EventModel;

import java.util.Set;

/**
 * Created by ffl on 30-01-2015.
 */
public interface EventRegistry {
    public void addEvent(BaseAggregateRoot aggregateRoot, String event);
    public Set<EventModel> events(BaseAggregateRoot aggregateRoot);
    public void deleteEvent(BaseAggregateRoot aggregateRoot, EventModel eventModel);

}
