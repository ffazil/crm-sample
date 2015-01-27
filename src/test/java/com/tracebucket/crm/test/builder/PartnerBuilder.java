package com.tracebucket.crm.test.builder;



import com.tracebucket.partner.domain.Partner;
import com.tracebucket.partner.domain.Partner;
import com.tracebucket.partner.domain.PartnerRole;
import com.tracebucket.common.dictionary.PartnerCategory;

import java.util.Set;

/**
 * Created by sadath on 11-Aug-14.
 */
public class PartnerBuilder {
    private PartnerBuilder(){ }

    public static PartnerBuilder aPartnerBuilder(){
        return new PartnerBuilder();
    }

    public Partner build(String title, String website){
        return new Partner(title, website);
    }

    public Partner build(String title, String website, String image, PartnerCategory partnerCategory){
        return new Partner(title, website, image, partnerCategory);
    }

    
}
