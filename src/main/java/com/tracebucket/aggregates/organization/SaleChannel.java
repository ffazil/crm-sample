package com.tracebucket.aggregates.organization;

import com.tracebucket.common.dictionary.SaleChannelType;
import com.tracebucket.infrastructure.ddd.domain.BaseEntity;
import com.tracebucket.partner.PartnerRole;

import javax.persistence.*;

/**
 * Created by ffl on 11-04-2014.
 */
@Entity
@Table(name = "SALE_CHANNEL")
public class SaleChannel extends BaseEntity {

    @Column(name = "NAME", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private String name;

    @Column(name = "DESCRIPTION")
    @Basic(fetch = FetchType.EAGER)
    private String description;

    @Column(name = "SALE_CHANNEL_TYPE", nullable = false,columnDefinition = "ENUM('STORE', 'WEB') default 'WEB'")
    @Enumerated(EnumType.STRING)
    @Basic(fetch = FetchType.EAGER)
    private SaleChannelType saleChannelType;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="ORGANIZATION_UNIT__ID", nullable = true)
    private OrganizationUnit organizationUnit;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="PARTNER_ROLE__ID", nullable = true)
    private PartnerRole partnerAffiliate;

    public SaleChannel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SaleChannelType getSaleChannelType() {
        return saleChannelType;
    }

    public void setSaleChannelType(SaleChannelType saleChannelType) {
        this.saleChannelType = saleChannelType;
    }

    public OrganizationUnit getOrganizationUnit() {
        return organizationUnit;
    }

    public void setOrganizationUnit(OrganizationUnit organizationUnit) {
        this.organizationUnit = organizationUnit;
    }

    public PartnerRole getPartnerAffiliate() {
        return partnerAffiliate;
    }

    public void setPartnerAffiliate(PartnerRole partnerAffiliate) {
        this.partnerAffiliate = partnerAffiliate;
    }
}
