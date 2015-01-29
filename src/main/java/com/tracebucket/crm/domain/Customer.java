package com.tracebucket.crm.domain;

import com.tracebucket.infrastructure.ddd.annotation.AggregateRoot;
import com.tracebucket.infrastructure.ddd.domain.BaseAggregateRoot;
import com.tracebucket.infrastructure.event.domain.DomainEvent;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@AggregateRoot
public class Customer extends BaseAggregateRoot{

	public enum CustomerStatus{
		STANDARD, VIP, PLATINUM
	}
	
	@Enumerated(EnumType.STRING)
	private CustomerStatus status;
	
	
	public void changeStatus(CustomerStatus status){
		this.status = status;
		
		//Sample Case: give 10% rebate for all draft orders - communication via events with different Bounded Context to achieve decoupling
        /*StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements.length);*/
		//eventPublisher.publish(new CustomerStatusChangedEvent(getAggregateId(), status));
//       queue(DomainEvent.name("customerStatusChanged"), DomainEvent.wrap(this));
	}
}
