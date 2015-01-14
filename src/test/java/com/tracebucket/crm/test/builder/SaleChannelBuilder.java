package com.tracebucket.crm.test.builder;

import com.tracebucket.organization.domain.OrganizationUnit;
import com.tracebucket.organization.domain.SaleChannel;
import com.tracebucket.partner.domain.PartnerRole;
import com.tracebucket.common.dictionary.SaleChannelType;

/**
 * Created by sadath on 25-Nov-14.
 */
public class SaleChannelBuilder {
    private String name;
    private String description;
    private SaleChannelType saleChannelType;
    private OrganizationUnit organizationUnit;
    private PartnerRole partner;

    public SaleChannelBuilder(){

    }

    public static SaleChannelBuilder aSaleChannel(){
        return new SaleChannelBuilder();
    }

    public SaleChannelBuilder withName(String name){
        this.name = name;
        return this;
    }

    public SaleChannelBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public SaleChannelBuilder withSaleChannelType(SaleChannelType saleChannelType){
        this.saleChannelType = saleChannelType;
        return this;
    }

    public SaleChannelBuilder withOrganizationUnit(OrganizationUnit organizationUnit){
        this.organizationUnit = organizationUnit;
        return this;
    }

    public SaleChannelBuilder withPartner(PartnerRole partner){
        this.partner = partner;
        return this;
    }

    public SaleChannel build(){
        SaleChannel saleChannel= new SaleChannel();
        saleChannel.setName(name);
        saleChannel.setDescription(description);
        saleChannel.setSaleChannelType(saleChannelType);
        saleChannel.setOrganizationUnit(organizationUnit);
        saleChannel.setPartnerAffiliate(partner);
        return saleChannel;
    }
}
