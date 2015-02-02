package com.tracebucket.infrastructure.ddd.domain;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ffl on 30-01-2015.
 */
public class EventModel implements Serializable{
    private final int identifier;
    private final String instance;
    private final String event;
    private final BaseAggregateRoot aggregateRoot;
    private final Date timestamp;

    private Cloner cloner;

    public EventModel(BaseAggregateRoot aggregateRoot, String event){
        this.instance = aggregateRoot.instanceId();
        this.identifier = aggregateRoot.hashCode();
        this.event = event;
        cloner = new Cloner();
        this.aggregateRoot = cloner.deepClone(aggregateRoot);
        this.timestamp = new Date();
    }

    public int getIdentifier() {
        return identifier;
    }

    public BaseAggregateRoot getAggregateRoot() {
        return aggregateRoot;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getEvent() {
        return event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventModel that = (EventModel) o;

        if (identifier != that.identifier) return false;
        if (!timestamp.equals(that.timestamp)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = identifier;
        result = 31 * result + timestamp.hashCode();
        return result;
    }
}
