package com.tracebucket.partner.domain;

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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="OWNER_ID")
    private Organization owner;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "PARTNER__ID")
    protected Set<PartnerRole> partnerRoles = new HashSet<PartnerRole>(0);

    public Partner() {

    }

    public Partner category(PartnerCategory partnerCategory){
        this.partnerCategory = partnerCategory;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Organization owner(){
        return owner;
    }

    public Partner owner(Organization owner){
        this.owner = owner;
        return this;
    }

    public Partner role(PartnerRole role){
        this.partnerRoles.add(role);
        return this;
    }

    public Set<PartnerRole> roles(){
        return this.partnerRoles;
    }

    public PartnerCategory category(){
        return this.partnerCategory;
    }



    public PartnerCategory getPartnerCategory() {
        return partnerCategory;
    }

    public void setPartnerCategory(PartnerCategory partnerCategory) {
        this.partnerCategory = partnerCategory;
    }

/*    public PartnerRole getPartnerRole() {
        return partnerRole;
    }

    public void setPartnerRole(PartnerRole partnerRole) {
        this.partnerRole = partnerRole;
    }*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<PartnerRole> getPartnerRoles() {
        return partnerRoles;
    }

    public void setPartnerRoles(Set<PartnerRole> partnerRoles) {
        this.partnerRoles = partnerRoles;
    }

    public Organization getOwner() {
        return owner;
    }

    public void setOwner(Organization owner) {
        this.owner = owner;
    }
}
