package com.tracebucket.partner.domain;

import com.tracebucket.common.domain.Address;
import com.tracebucket.infrastructure.ddd.domain.AggregateId;
import com.tracebucket.organization.domain.Organization;
import com.tracebucket.common.dictionary.PartnerCategory;
import com.tracebucket.infrastructure.ddd.annotation.AggregateRoot;
import com.tracebucket.infrastructure.ddd.domain.BaseAggregateRoot;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by sadath on 05-Aug-14.
 */
@AggregateRoot
@Entity
@Table(name = "PARTNER")
public class Partner extends BaseAggregateRoot{
    @Column(name = "TITLE", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    protected String title;

    @Column(name = "IMAGE")
    @Basic(fetch = FetchType.EAGER)
    protected String image;

    @Column(name = "WEBSITE")
    @Basic(fetch = FetchType.EAGER)
    protected String website;

    @Column(name = "PARTNER_CATEGORY", nullable = false, columnDefinition = "ENUM('INDIVIDUAL', 'GROUP', 'ORGANIZATION') default 'ORGANIZATION'")
    @Enumerated(EnumType.STRING)
    @Basic(fetch = FetchType.EAGER)
    protected PartnerCategory partnerCategory;

    @Embedded
    private Owner owner;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "PARTNER__ID")
    protected Set<PartnerRole> partnerRoles = new HashSet<PartnerRole>(0);

    public Partner() {

    }

    public void setPartnerCategory(PartnerCategory partnerCategory){

        this.partnerCategory = partnerCategory;
    }

    public void movePartnerToCategory(PartnerCategory newPartnerCategory){
        this.partnerCategory = newPartnerCategory;
    }

    public void addPartnerRole(PartnerRole newPartnerRole){
        this.partnerRoles.add(newPartnerRole);
    }

    public Boolean hasPartnerRole(PartnerRole partnerRole){
        Long found = partnerRoles.parallelStream()
            .filter(t -> t.getId() == partnerRole.getId())
            .count();
        return (found != null && found > 0) ? true : false;
    }

    public void addAddressToRole(PartnerRole partnerRole, Address address){
       partnerRole.getAddresses().add(address);
    }

    public void moveRoleAddressTo(PartnerRole partnerRole, Address newAddress){

        Long foundId = partnerRoles.parallelStream()
                .filter(t -> t.getId() == partnerRole.getId())
                .count();

        if(partnerRole.getId() == foundId){

            partnerRole.getAddresses().add(newAddress);
        }
    }

    public void changeOwner(Owner newOwner){
        this.owner = newOwner;
    }

    public Set<PartnerRole> getAllAssignedRoles(){

        return partnerRoles;  //iteration

    }

}
