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
import java.util.*;

/**
 * @author FFL
 */

@Configurable
@Scope("prototype")//created in domain factories, not in spring container, therefore we don't want eager creation
@MappedSuperclass
@EntityListeners(AggregateRootListener.class)
public abstract class  BaseAggregateRoot extends BaseDomain{
	public static enum AggregateStatus {
		ACTIVE, ARCHIVE
	}

	@EmbeddedId
	@AttributeOverrides({
		  @AttributeOverride(name = "aggregateId", column = @Column(name = "ID", nullable = false))})
	protected AggregateId aggregateId;



	@Version
	private Long version;

	@Enumerated(EnumType.ORDINAL)
	private AggregateStatus aggregateStatus = AggregateStatus.ACTIVE;

    @Transient
    @Autowired
    private EventHandlerHelper eventHandlerHelper;

    @Transient
    transient private Set<String> events = new HashSet<>(0);

    @Transient
    private final String _instanceId;



    public BaseAggregateRoot(){
        aggregateId = AggregateId.generate();
        _instanceId = UUID.randomUUID().toString();
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

    public void fireEvent(String event){
        events.add(event);
    }

    public EventHandlerHelper getEventHandlerHelper() {
        return eventHandlerHelper;
    }

    public Set<String> getEvents() {
        return events;
    }

    @Override
	public int hashCode() {	
		return aggregateId.hashCode();
	}

    public String instanceId(){
        return _instanceId;
    }


}
