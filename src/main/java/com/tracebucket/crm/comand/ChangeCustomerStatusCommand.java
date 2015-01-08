package com.tracebucket.crm.comand;



import com.tracebucket.crm.domain.Customer;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;

import java.io.Serializable;

public class ChangeCustomerStatusCommand implements Serializable{

	private AggregateId customerId;
	
	private Customer.CustomerStatus status;

    public ChangeCustomerStatusCommand(){

    }

    public void setCustomerId(AggregateId customerId) {
        this.customerId = customerId;
    }

    public void setStatus(Customer.CustomerStatus status) {
        this.status = status;
    }

    public ChangeCustomerStatusCommand(AggregateId customerId, Customer.CustomerStatus status) {
		super();
		this.customerId = customerId;
		this.status = status;
	}

	public AggregateId getCustomerId() {
		return customerId;
	}

	public Customer.CustomerStatus getStatus() {
		return status;
	}
	
	
}
