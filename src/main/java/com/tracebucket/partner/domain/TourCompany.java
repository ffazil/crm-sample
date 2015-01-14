package com.tracebucket.partner.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by vishwa on 10-12-2014.
 */
@Entity(name = "PARTNER_TOUR_COMPANY")
@Table(name = "PARTNER_TOUR_COMPANY")
@PrimaryKeyJoinColumn(name="PARTNER_ROLE__ID")
@DiscriminatorValue(value = "PARTNER_TOURCOMPANY")
public class TourCompany extends PartnerRole implements Serializable {

    private static final String simpleName = "Tour Company";

    @Override
    public String simpleName() {
        return simpleName;
    }
}
