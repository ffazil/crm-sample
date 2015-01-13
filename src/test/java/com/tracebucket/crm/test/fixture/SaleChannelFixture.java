package com.tracebucket.crm.test.fixture;

import com.tracebucket.aggregates.organization.OrganizationUnit;
import com.tracebucket.aggregates.organization.SaleChannel;
import com.tracebucket.common.dictionary.SaleChannelType;
import com.tracebucket.crm.test.builder.SaleChannelBuilder;

/**
 * Created by sadath on 25-Nov-14.
 */
public class SaleChannelFixture {
    public static SaleChannel standardSaleChannelStore(){
        OrganizationUnit organizationUnit = OrganizationUnitFixture.standardOrganizationUnit();
        SaleChannel saleChannel = SaleChannelBuilder.aSaleChannel()
                .withName("Kiosk")
                .withDescription("Kiosk Description")
                .withSaleChannelType(SaleChannelType.STORE)
                //.withOrganizationUnit(organizationUnit)
                .build();
        return saleChannel;
    }

    public static SaleChannel standardSaleChannelWeb(){
        OrganizationUnit organizationUnit = OrganizationUnitFixture.standardOrganizationUnit();
        SaleChannel saleChannel = SaleChannelBuilder.aSaleChannel()
                .withName("Portal")
                .withDescription("Portal Description")
                .withSaleChannelType(SaleChannelType.WEB)
                // .withOrganizationUnit(organizationUnit)
                .build();
        return saleChannel;
    }
}
