/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * 
 */
package com.tracebucket.infrastructure.ddd.domain;

import com.tracebucket.infrastructure.ddd.exception.DomainOperationException;
import com.tracebucket.infrastructure.event.domain.EventHandlerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import reactor.core.Reactor;
import reactor.event.Event;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Configurable
@Scope("prototype")//created in domain factories, not in spring container, therefore we don't want eager creation
@MappedSuperclass
public abstract class  BaseAggregateRoot {
	public static enum AggregateStatus {
		ACTIVE, ARCHIVE
	}

	@EmbeddedId
	@AttributeOverrides({
		  @AttributeOverride(name = "idValue", column = @Column(name = "aggregateId", nullable = false))})
	protected AggregateId aggregateId;



	@Version
	private Long version;

	@Enumerated(EnumType.ORDINAL)
	private AggregateStatus aggregateStatus = AggregateStatus.ACTIVE;

    @Transient
    @Autowired
    private EventHandlerHelper eventHandlerHelper;

    @Transient
    private static Map<String, Event> events = new HashMap<String, Event>(0);



    public BaseAggregateRoot(){

    }
	
	public void markAsRemoved() {
		aggregateStatus = AggregateStatus.ARCHIVE;
	}

	public AggregateId getAggregateId() {
		return aggregateId;
	}

	public boolean isRemoved() {
		return aggregateStatus == AggregateStatus.ARCHIVE;
	}
	
	protected void domainError(String message) {
		throw new DomainOperationException(aggregateId, message);
	}

    protected EventHandlerHelper eventHandlerHelper(){
        return eventHandlerHelper;
    }
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof BaseAggregateRoot) {
			BaseAggregateRoot other = (BaseAggregateRoot) obj;
			if (other.aggregateId == null)
				return false;
			return other.aggregateId.equals(aggregateId);
		}
		
		return false;
	}

    protected BaseAggregateRoot queue(String name, Event event){
        events.put(name, event);
        return this;
    }

    @PrePersist
    @PreUpdate
    @PreRemove
    public void publishEvents(){
        eventHandlerHelper.notify(events);
    }


	
	@Override
	public int hashCode() {	
		return aggregateId.hashCode();
	}
}
