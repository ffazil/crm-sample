package com.tracebucket.crm.test.builder;

import com.tracebucket.organization.domain.Department;

/**
 * Created by sadath on 25-Nov-14.
 */
public class DepartmentBuilder {
    private String name;
    private String description;

    public DepartmentBuilder(){ }

    public static DepartmentBuilder aDepartment(){
        return new DepartmentBuilder();
    }

    public DepartmentBuilder withName(String name){
        this.name = name;
        return this;
    }

    public DepartmentBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public Department build(){
        Department department = new Department();
        department.setName(name);
        department.setDescription(description);
        return department;
    }
}
