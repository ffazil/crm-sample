package com.tracebucket.crm.test.fixture;

import com.tracebucket.organization.domain.Organization;
import com.tracebucket.common.dictionary.PartnerCategory;
import com.tracebucket.crm.test.builder.PartnerBuilder;
import com.tracebucket.partner.domain.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sadath on 11-Aug-14.
 */
public class PartnerFixture {
    public static Partner allRoles() {

        Customer customer = CustomerFixture.standardCustomer();
        Affiliate affiliate = AffiliateFixture.standardAffiliate();
        EntertainmentCompany entertainmentCompany = EntertainmentCompanyFixture.standardEntertainmentCompany();
        Organization owner = OrganizationFixture.standardOrganization();

        Set<PartnerRole> PartnerRoles = new HashSet<PartnerRole>();
       // PartnerRoles.add(supplier);
       PartnerRoles.add(customer);
       PartnerRoles.add(affiliate);
        PartnerRoles.add(entertainmentCompany);
       /* PartnerRoles.add(warehouseProvider);
        PartnerRoles.add(logisticsProvider);
        PartnerRoles.add(paymentProvider);
       */ Partner partner = PartnerBuilder.anPartner()
                .withTitle("Partner " + new Date().getTime())
                .withImage("Image" + new Date().getTime())
                .withWebsite("wwww.zzz.nl")
                .withOwner(owner)
                .withPartnerCategory(PartnerCategory.GROUP)
                .withPartnerRoles(PartnerRoles)
                .build();
        return partner;
    }
}
