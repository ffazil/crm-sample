package com.tracebucket.crm.test.fixture;


import com.tracebucket.common.dictionary.PartnerCategory;
import com.tracebucket.common.domain.Address;
import com.tracebucket.crm.test.builder.PartnerBuilder;
import com.tracebucket.partner.domain.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by sadath on 11-Aug-14.
 */
public class PartnerFixture {

    public static Partner standardPartner() {
        Partner partner = PartnerBuilder.aPartnerBuilder()
                .build("Title " + new Date().getTime(), UUID.randomUUID().toString(),"image");
        return partner;
    }

    public static Partner setPartnerCategory(PartnerCategory partnerCategory, Partner partner) {
        partner.setPartnerCategory(partnerCategory);
        return partner;
    }

    public static Partner movePartnerToCategory(PartnerCategory partnerCategory, Partner partner) {
        partner.movePartnerToCategory(partnerCategory);
        return partner;
    }

    public static  Partner addPartnerRole(PartnerRole newPartnerRole, Partner partner) {
        partner.addPartnerRole(newPartnerRole);
        return partner;
    }

    public Boolean hasPartnerRole(PartnerRole partnerRole, Partner partner){
        return partner.hasPartnerRole(partnerRole);
    }

    public static Partner addAddressToRole(Address newAddress, PartnerRole partnerRole, Partner partner){
        partner.addAddressToRole(partnerRole,newAddress);
        return partner;
    }

    public static Partner moveRoleAddressTo(PartnerRole partnerRole, Address newAddress, Partner partner){

           partner.moveRoleAddressTo(partnerRole, newAddress);
           return partner;
    }

    public static Partner changeOwner(Owner newOwner, Partner partner){
       partner.changeOwner(newOwner);
       return partner;
    }



}
