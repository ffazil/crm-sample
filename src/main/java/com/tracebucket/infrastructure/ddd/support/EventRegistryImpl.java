package com.tracebucket.infrastructure.ddd.support;

import com.tracebucket.infrastructure.ddd.domain.BaseAggregateRoot;
import com.tracebucket.infrastructure.ddd.domain.EventModel;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ffl on 30-01-2015.
 */
@Component
public class EventRegistryImpl implements EventRegistry{

    private ConcurrentHashMap<String, HashSet<EventModel>> eventModelMap = new ConcurrentHashMap<String, HashSet<EventModel>>(0);



    public EventRegistryImpl(){

    }

    @Override
    public void addEvent(BaseAggregateRoot aggregateRoot, String event) {
        String aggregateId = aggregateRoot.getAggregateId().getId();
        EventModel eventModel = new EventModel(aggregateRoot, event);
        if(eventModelMap.containsKey(aggregateId)){
            Set<EventModel> eventModels = eventModelMap.get(aggregateId);
            eventModels.add(eventModel);
        }
        else{
            HashSet<EventModel> eventModels = new HashSet<>(0);
            eventModels.add(eventModel);
            eventModelMap.put(aggregateId, eventModels);
        }
    }

    @Override
    public Set<EventModel> events(BaseAggregateRoot aggregateRoot) {
        String aggregateId = aggregateRoot.getAggregateId().getId();
        HashSet<EventModel> eventModels = new HashSet<>(0);
        if(eventModelMap.get(aggregateId) != null)
            eventModels.addAll(eventModelMap.get(aggregateId));
        return eventModels;
    }

    @Override
    public void deleteEvent(BaseAggregateRoot aggregateRoot, EventModel eventModel) {
        String aggregateId = aggregateRoot.getAggregateId().getId();
        if(eventModelMap.containsKey(aggregateId)){
            HashSet<EventModel> eventModels = eventModelMap.get(aggregateId);
            if(eventModels != null){
                eventModels.remove(eventModel);
            }
        }
    }
}
