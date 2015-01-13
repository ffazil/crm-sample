package com.tracebucket.partner;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by vishwa on 10-12-2014.
 */
@Entity
@Table(name = "TRANSPORT_PROVIDER")
@PrimaryKeyJoinColumn(name="PARTNER_ROLE__ID")
@DiscriminatorValue(value = "TRANSPORT_PROVIDER")
public class TransportProvider extends PartnerRole {

    private static final String simpleName = "Transport Provider";

    @Override
    public String simpleName() {
        return simpleName;
    }
}
