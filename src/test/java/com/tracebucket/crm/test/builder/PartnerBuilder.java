package com.tracebucket.crm.test.builder;



import com.tracebucket.aggregates.partner.Partner;
import com.tracebucket.aggregates.partner.PartnerRole;
import com.tracebucket.common.dictionary.PartnerCategory;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sadath on 11-Aug-14.
 */
public class PartnerBuilder {
    private String title;
    private String image;
    private PartnerCategory partnerCategory;
    private Set<PartnerRole> partnerRoles = null;

    private PartnerBuilder(){ }

    public static PartnerBuilder anPartner(){
        return new PartnerBuilder();
    }

    public PartnerBuilder withTitle(String title){
        this.title = title;
        return this;
    }

    public PartnerBuilder withImage(String image){
        this.image = image;
        return this;
    }

    public PartnerBuilder withPartnerCategory(PartnerCategory partnerCategory){
        this.partnerCategory = partnerCategory;
        return this;
    }

    public PartnerBuilder withPartnerRoles(Set<PartnerRole> partnerRoles){
        this.partnerRoles = partnerRoles;
        return this;
    }

    public Partner build(){
        Partner partner = new Partner();
        partner.setTitle(title);
        partner.setImage(image);
        partner.setPartnerCategory(partnerCategory);
        partner.setPartnerRoles(partnerRoles);
        return partner;
    }
    
}
