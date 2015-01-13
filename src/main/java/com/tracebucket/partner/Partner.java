package com.tracebucket.partner;


import com.mmpsoftware.aurora.common.dictionary.PartnerCategory;
import com.mmpsoftware.aurora.common.domain.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by sadath on 05-Aug-14.
 */
@Entity
@Table(name = "PARTNER")
public class Partner extends BaseEntity{
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
        checkNotNull(partnerCategory, "Partner category cannot be null");

        this.partnerCategory = partnerCategory;
        return this;
    }

    public Organization owner(){
        return owner;
    }

    public Partner owner(Organization owner){
        checkNotNull(owner, "Owner cannot be null");

        this.owner = owner;
        return this;
    }

    public Partner role(PartnerRole role){
        checkNotNull(role, role.simpleName() + " cannot be null");

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
