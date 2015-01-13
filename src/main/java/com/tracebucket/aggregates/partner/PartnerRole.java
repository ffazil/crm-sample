package com.tracebucket.aggregates.partner;



import com.tracebucket.common.domain.Address;
import com.tracebucket.infrastructure.ddd.domain.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sadath on 05-Aug-14.
 */
@Entity
@Table(name = "PARTNER_ROLE")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PARTNER_ROLE", discriminatorType = DiscriminatorType.STRING)
public abstract class PartnerRole extends BaseEntity implements Serializable{

    @Column(name = "NAME")
    @Basic(fetch = FetchType.EAGER)
    private String name;

    @ElementCollection
    @JoinTable(name = "PARTNER_ADDRESS", joinColumns = @JoinColumn(name = "PARTNER__ID"))
    private Set<Address> addresses = new HashSet<Address>(0);

    public abstract String simpleName();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}

