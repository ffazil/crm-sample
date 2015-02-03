package com.tracebucket.crm.service.impl;

import com.tracebucket.common.dictionary.PartnerCategory;
import com.tracebucket.common.domain.Address;
import com.tracebucket.crm.service.PartnerService;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;
import com.tracebucket.partner.domain.Owner;
import com.tracebucket.partner.domain.Partner;
import com.tracebucket.partner.domain.PartnerRole;
import com.tracebucket.partner.repository.jpa.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vishwa on 27-01-2015.
 */
@Service
@Transactional
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public Partner save(Partner partner) {
        return partnerRepository.save(partner);
    }

    @Override
    public Partner findOne(AggregateId aggregateId) {
        return partnerRepository.findOne(aggregateId);
    }

    @Override
    public boolean delete(AggregateId partnerAggregateId) {
        Partner partner = partnerRepository.findOne(partnerAggregateId);
        if(partner != null) {
            partnerRepository.delete(partner);
            return partnerRepository.findOne(partnerAggregateId) == null ? true : false;
        }
        return false;
    }

    @Override
    public Partner setPartnerCategory(PartnerCategory partnerCategory, AggregateId partnerAggregateId){

        Partner partner = partnerRepository.findOne(partnerAggregateId);
        if(partner != null) {
            partner.setPartnerCategory(partnerCategory);
            return partnerRepository.save(partner);
        }
        return null;
    }

    /*@Override
    public Partner movePartnerToCategory(PartnerCategory newPartnerCategory,AggregateId partnerAggregateId){

    }
*/
    @Override
    public Partner addPartnerRole(PartnerRole newPartnerRole, AggregateId partnerAggregateId){

        Partner partner = partnerRepository.findOne(partnerAggregateId);
        if(partner != null) {
            partner.addPartnerRole(newPartnerRole);
            return partnerRepository.save(partner);
        }
        return null;

    }

    @Override
    public Partner addAddressToRole(PartnerRole partnerRole, Address address, AggregateId partnerAggregateId){

        Partner partner = partnerRepository.findOne(partnerAggregateId);
        if(partner != null) {
            partner.addAddressToRole(partnerRole, address);
            return partnerRepository.save(partner);
        }
        return null;
    }

   /* @Override
    public Partner moveRoleAddressTo(PartnerRole partnerRole, Address newAddress,AggregateId partnerAggregateId){

    }*/

    @Override
    public Partner changeOwner(Owner newOwner, AggregateId partnerAggregateId){
        Partner partner = partnerRepository.findOne(partnerAggregateId);
        if(partner != null) {
            partner.changeOwner(newOwner);
            return partnerRepository.save(partner);
        }
        return null;

    }
    
    @Override
    public Boolean hasPartnerRole(PartnerRole partnerRole, AggregateId partnerAggregateId){

        Long found = null;
        Partner partner = partnerRepository.findOne(partnerAggregateId);
        if(partner != null) {
            found = partner.getAllAssignedRoles().parallelStream()
                    .filter(t -> t.getId() == partnerRole.getId())
                    .count();
        }

        return (found != null && found > 0) ? true : false;

    }
}
