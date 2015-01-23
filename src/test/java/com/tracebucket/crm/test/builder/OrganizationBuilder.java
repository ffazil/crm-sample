package com.tracebucket.crm.test.builder;

import com.tracebucket.organization.domain.Organization;
import com.tracebucket.organization.domain.OrganizationUnit;
import com.tracebucket.common.domain.*;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sadath on 25-Nov-14.
 */
public class OrganizationBuilder {

    private OrganizationBuilder(){ }

    public static OrganizationBuilder anOrganizationBuilder(){
        return new OrganizationBuilder();
    }

    public Organization build(String name, String code, String description){
        return new Organization(name, code, description);
    }

    public Organization build(String name, String code, String description, String website, String image){
        return new Organization(name, code, description, website, image);
    }

}