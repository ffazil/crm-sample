package com.tracebucket.aggregates.partner;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by vishwa on 10-12-2014.
 */
@Entity(name = "PARTNER_MUSEUMS")
@Table(name = "PARTNER_MUSEUMS")
@PrimaryKeyJoinColumn(name="PARTNER_ROLE__ID")
@DiscriminatorValue(value = "PARTNER_MUSEUMS")
public class Museums extends PartnerRole {

    private static final String simpleName = "Museums";

    @Override
    public String simpleName() {
        return simpleName;
    }
}
