package com.tracebucket.partner.service;

import com.tracebucket.common.dictionary.PartnerCategory;
import com.tracebucket.common.domain.Address;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;
import com.tracebucket.partner.domain.Owner;
import com.tracebucket.partner.domain.Partner;
import com.tracebucket.partner.domain.PartnerRole;

/**
 * Created by vishwa on 23-01-2015.
 */
public interface PartnerService {

    public Partner save(Partner partner);
    public Partner findOne(AggregateId aggregateId);
    public boolean delete(AggregateId partnerAggregateId);
    public Partner setPartnerCategory(PartnerCategory partnerCategory, AggregateId partnerAggregateId);
    //public Partner movePartnerToCategory(PartnerCategory newPartnerCategory,AggregateId partnerAggregateId);
    public Partner addPartnerRole(PartnerRole newPartnerRole,AggregateId partnerAggregateId);
    public Partner addAddressToRole(PartnerRole partnerRole, Address address,AggregateId partnerAggregateId);
   // public Partner moveRoleAddressTo(PartnerRole partnerRole, Address newAddress,AggregateId partnerAggregateId);
    public Partner changeOwner(Owner newOwner,AggregateId partnerAggregateId);
    public Boolean hasPartnerRole(PartnerRole partnerRole,AggregateId partnerAggregateId);
}
