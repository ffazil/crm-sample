package com.tracebucket.crm.service;

import com.tracebucket.infrastructure.ddd.domain.AggregateId;
import com.tracebucket.partner.domain.Partner;

/**
 * Created by vishwa on 23-01-2015.
 */
public interface PartnerService {

    public Partner save(Partner partner);
    public boolean delete(AggregateId partnerAggregateId);

}
