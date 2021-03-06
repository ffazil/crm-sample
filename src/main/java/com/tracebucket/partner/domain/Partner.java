package com.tracebucket.partner.domain;

import com.tracebucket.common.domain.Address;
import com.tracebucket.common.dictionary.PartnerCategory;
import com.tracebucket.infrastructure.ddd.annotation.AggregateRoot;
import com.tracebucket.infrastructure.ddd.annotation.DomainMethod;
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


    @OneToMany(cascade = CascadeType.ALL, /*orphanRemoval = true, */fetch = FetchType.EAGER)
    @JoinColumn(name = "PARTNER__ID")
    protected Set<PartnerRole> partnerRoles = new HashSet<PartnerRole>(0);

    public Partner() {
    }

    public Partner(String title, String website){

        this.title = title;
        this.website = website;
    }

    public Partner (String title, String website, String image, PartnerCategory partnerCategory){

        this.title = title;
        this.website = website;
        this.image = image;
        this.partnerCategory = partnerCategory;
    }

    @DomainMethod(event = "PartnerCategorySet")
    public void setPartnerCategory(PartnerCategory partnerCategory){

        this.partnerCategory = partnerCategory;
    }

    @DomainMethod(event = "PartnerMoved")
    public void movePartnerToCategory(PartnerCategory newPartnerCategory){
        this.partnerCategory = newPartnerCategory;
    }

    @DomainMethod(event = "PartnerRoleAdded")
    public void addPartnerRole(PartnerRole newPartnerRole){
        this.partnerRoles.add(newPartnerRole);
    }

    public Boolean hasPartnerRole(PartnerRole partnerRole){
        Long found = partnerRoles.parallelStream()
            .filter(t -> t.getEntityId() == partnerRole.getEntityId())
            .count();
        return (found != null && found > 0) ? true : false;
    }

    @DomainMethod(event = "AddressAddedToRole")
    public void addAddressToRole(PartnerRole partnerRole, Address address){
       partnerRole.getAddresses().add(address);
    }

    @DomainMethod(event = "RoleAddressMoved")
    public void moveRoleAddressTo(PartnerRole partnerRole, Address newAddress){

        PartnerRole roleFound = partnerRoles.parallelStream()
                .filter(t -> t.getEntityId().equals(partnerRole.getEntityId()))
                .findFirst().get();

        if(roleFound != null){
            roleFound.getAddresses().add(newAddress);
        }
    }

    @DomainMethod(event = "OwnerChanged")
    public void changeOwner(Owner newOwner){
        this.owner = newOwner;
    }

    public Set<PartnerRole> getAllAssignedRoles(){

        return partnerRoles;  //iteration

    }

    public Owner getOwner() {
        return owner;
    }

    @DomainMethod(event = "OwnerSet")
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public PartnerCategory getPartnerCategory(){return this.partnerCategory;}
}
