package com.tracebucket.crm.test.fixture;

import com.tracebucket.aggregates.organization.BusinessLine;
import com.tracebucket.crm.test.builder.BusinessLineBuilder;

/**
 * Created by sadath on 25-Nov-14.
 */
public class BusinessLineFixture {
    public static BusinessLine standardBusinessLine(){
        BusinessLine businessLine = BusinessLineBuilder.aBusinessLine()
                .withName("Business Line1")
                .withDescription("Business line description")
                .build();
        return businessLine;
    }
}
