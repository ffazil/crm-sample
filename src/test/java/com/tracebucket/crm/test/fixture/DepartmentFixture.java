package com.tracebucket.crm.test.fixture;

import com.tracebucket.organization.domain.Department;
import com.tracebucket.crm.test.builder.DepartmentBuilder;

/**
 * Created by sadath on 25-Nov-14.
 */
public class DepartmentFixture {
    public static Department standardDepartment(){
        Department department = DepartmentBuilder.aDepartment()
                .withName("Account")
                .withDescription("Account desc")
                .build();
        return department;
    }
}
