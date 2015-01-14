package com.tracebucket.aggregates.partner;

import com.tracebucket.common.domain.Person;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sadath on 05-Aug-14.
 */
@Entity(name = "PARTNER_AFFILIATE")
@Table(name = "PARTNER_AFFILIATE")
@PrimaryKeyJoinColumn(name="PARTNER_ROLE__ID")
@DiscriminatorValue(value = "PARTNER_AFFILIATE")
public class Affiliate extends PartnerRole implements Serializable {
    private static final String simpleName = "Affiliate";

    @Column(name = "BUSINESS_NAME")
    @Basic(fetch = FetchType.EAGER)
    private String businessName;

    @Column(name = "CODE")
    @Basic(fetch = FetchType.EAGER)
    private String code;

    @Column(name = "DATE_OF_INCORPORATION")
    @Basic(fetch = FetchType.EAGER)
    private Date dateOfIncorporation;

    @Column(name = "LOGO")
    @Basic(fetch = FetchType.EAGER)
    private String logo;

    @Column(name = "WEBSITE")
    @Basic(fetch = FetchType.EAGER)
    private String website;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(
            name="AFFILIATE_PERSON",
            joinColumns={ @JoinColumn(name="AFFILIATE__ID", referencedColumnName="ID") },
            inverseJoinColumns={ @JoinColumn(name="PERSON__ID", referencedColumnName="ID", unique=false) }
    )
    private Set<Person> persons = new HashSet<Person>(0);

/*    @OneToMany(mappedBy = "partner", fetch = FetchType.EAGER)
    private Set<SaleChannel> saleChannels = new HashSet<>(0);*/

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDateOfIncorporation() {
        return dateOfIncorporation;
    }

    public void setDateOfIncorporation(Date dateOfIncorporation) {
        this.dateOfIncorporation = dateOfIncorporation;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String simpleName() {
        return simpleName;
    }

/*    public Set<SaleChannel> getSaleChannels() {
        return saleChannels;
    }

    public void setSaleChannels(Set<SaleChannel> saleChannels) {
        this.saleChannels = saleChannels;
    }*/
}
