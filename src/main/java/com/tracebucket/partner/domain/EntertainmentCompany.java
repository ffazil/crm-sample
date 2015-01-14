package com.tracebucket.partner.domain;

import com.tracebucket.common.domain.Person;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ffl on 29-10-2014.
 */
@Entity(name = "PARTNER_ENTERTAINMENT_COMPANY")
@Table(name = "PARTNER_ENTERTAINMENT_COMPANY")
@PrimaryKeyJoinColumn(name="PARTNER_ROLE__ID")
@DiscriminatorValue(value = "PARTNER_ENTERTAINMENT_COMPANY")
public class EntertainmentCompany extends PartnerRole implements Serializable{
    private static final String simpleName = "Entertainment Company";

    @Override
    public String simpleName() {
        return simpleName;
    }

    @Column(name = "NAME", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    protected String name;

    @Column(name = "WEBSITE", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    protected String website;

    @Column(name = "LOGO", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    protected String logo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(
            name="ENT_COMP_PERSONS",
            joinColumns={ @JoinColumn(name="ENTERTAINMENT_COMPANY__ID", referencedColumnName="ID") },
            inverseJoinColumns={ @JoinColumn(name="PERSON__ID", referencedColumnName="ID", unique=false) }
    )
    protected Set<Person> contactPersons = new HashSet<Person>(0);

/**Contract terms to be defined*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Set<Person> getContactPersons() {
        return contactPersons;
    }

    public void setContactPersons(Set<Person> contactPersons) {
        this.contactPersons = contactPersons;
    }
}
