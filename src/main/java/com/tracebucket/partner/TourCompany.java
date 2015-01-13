package com.tracebucket.partner;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by vishwa on 10-12-2014.
 */
@Entity
@Table(name = "TOURCOMPANY")
@PrimaryKeyJoinColumn(name="PARTNER_ROLE__ID")
@DiscriminatorValue(value = "TOURCOMPANY")
public class TourCompany extends PartnerRole {

    private static final String simpleName = "Tour Company";

    @Override
    public String simpleName() {
        return simpleName;
    }
}
