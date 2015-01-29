package com.tracebucket.crm.test.fixture;

import com.tracebucket.crm.test.builder.OwnerBuilder;
import com.tracebucket.partner.domain.Owner;

import java.util.Date;

/**
 * Created by vishwa on 23-01-2015.
 */
public class OwnerFixture {

    public static Owner standardOwner() {
        Owner owner = OwnerBuilder.anOwnerBuilder()
                .withName("Name " + new Date().getTime())
                .build();
        return owner;
    }

    public static Owner standardOwner2() {
        Owner owner = OwnerBuilder.anOwnerBuilder()
                .withName("Name_UPDT ")
                .build();
        return owner;
    }
}
