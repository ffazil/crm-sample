package com.tracebucket.crm.test.builder;

import com.tracebucket.partner.domain.Owner;

/**
 * Created by vishwa on 23-01-2015.
 */
public class OwnerBuilder {

    private String name;

    private OwnerBuilder(){ }

    public static OwnerBuilder anOwnerBuilder(){
        return new OwnerBuilder();
    }

    public OwnerBuilder withName(String name){
        this.name = name;
        return this;
    }

    public Owner build(){
        Owner owner = new Owner();
        owner.setName(name);

        return owner;
    }
}
