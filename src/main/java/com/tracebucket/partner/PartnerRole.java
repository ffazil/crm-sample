package com.tracebucket.partner;

import com.mmpsoftware.aurora.common.domain.Address;
import com.mmpsoftware.aurora.common.domain.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sadath on 05-Aug-14.
 */
@Entity
@Table(name = "PARTNER_ROLE")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PARTNER_ROLE", discriminatorType = DiscriminatorType.STRING)
public abstract class PartnerRole extends BaseEntity {

    @Column(name = "NAME")
    @Basic(fetch = FetchType.EAGER)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(
            name="PARTNER_ADDRESS",
            joinColumns={ @JoinColumn(name="PARTNER__ID", referencedColumnName="ID") },
            inverseJoinColumns={ @JoinColumn(name="ADDRESS__ID", referencedColumnName="ID", unique=true) }
    )
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

