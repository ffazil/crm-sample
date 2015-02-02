package com.tracebucket.infrastructure.ddd.support;

import com.tracebucket.infrastructure.ddd.domain.BaseAggregateRoot;
import com.tracebucket.infrastructure.ddd.domain.EventModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ffl on 30-01-2015.
 */
@Component
public class EventRegistryImpl implements EventRegistry{
    private static Logger log = LoggerFactory.getLogger(EventRegistryImpl.class);

    private ConcurrentHashMap<String, HashSet<EventModel>> eventModelMap = new ConcurrentHashMap<String, HashSet<EventModel>>(0);



    public EventRegistryImpl(){

    }

    @Override
    public void addEvent(BaseAggregateRoot aggregateRoot, String event) {
        String instance = aggregateRoot.instanceId();
        EventModel eventModel = new EventModel(aggregateRoot, event);
        if(eventModelMap.containsKey(instance)){
            Set<EventModel> eventModels = eventModelMap.get(instance);
            eventModels.add(eventModel);
        }
        else{
            HashSet<EventModel> eventModels = new HashSet<>(0);
            eventModels.add(eventModel);
            eventModelMap.put(instance, eventModels);
        }
        log.info("Adding event " + event + " for instance " + aggregateRoot.instanceId());
    }

    @Override
    public Set<EventModel> events(BaseAggregateRoot aggregateRoot) {
        String instance = aggregateRoot.instanceId();
        HashSet<EventModel> eventModels = new HashSet<>(0);
        if(eventModelMap.get(instance) != null){
            eventModels.addAll(eventModelMap.get(instance));
            log.info("Fetched all events for instance = " + instance);
        }

        return eventModels;
    }

    @Override
    public void deleteInstanceEvents(BaseAggregateRoot aggregateRoot) {
        String instance = aggregateRoot.instanceId();
        if(eventModelMap.containsKey(instance)){
            eventModelMap.remove(instance);
            log.info("Deleted all events for instance = " + instance);
        }

    }
}
