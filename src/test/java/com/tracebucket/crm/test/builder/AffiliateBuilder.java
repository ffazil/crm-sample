package com.tracebucket.crm.test.builder;

import com.tracebucket.partner.domain.Affiliate;
import com.tracebucket.common.domain.Address;
import com.tracebucket.common.domain.Person;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sadath on 11-Aug-14.
 */
public class AffiliateBuilder {
    private String name;
    private String businessName;
    private String code;
    private Date dateOfIncorporation;
    private String logo;
    private String website;
    private Set<Person> persons = new HashSet<Person>(0);
  //  private Set<SaleChannel> saleChannels = new HashSet<>(0);
    private Set<Address> addresses = new HashSet<Address>(0);

    public AffiliateBuilder(){

    }

    public static AffiliateBuilder aAffiliate(){
        return new AffiliateBuilder();
    }

    public AffiliateBuilder withName(String name){
        this.name = name;
        return this;
    }

    public AffiliateBuilder withBusinessName(String businessName){
        this.businessName = businessName;
        return this;
    }

    public AffiliateBuilder withCode(String code){
        this.code = code;
        return this;
    }

    public AffiliateBuilder withDateOfIncorporation(Date dateOfIncorporation){
        this.dateOfIncorporation = dateOfIncorporation;
        return this;
    }

    public AffiliateBuilder withLogo(String logo){
        this.logo = logo;
        return this;
    }

    public AffiliateBuilder withWebsite(String website){
        this.website = website;
        return this;
    }

    public AffiliateBuilder withPersons(Set<Person> persons){
        this.persons = persons;
        return this;
    }

   /* public AffiliateBuilder withSaleChannels(Set<SaleChannel> saleChannels){
        this.saleChannels = saleChannels;
        return this;
    }*/

    public AffiliateBuilder withAddresses(Set<Address> addresses){
        this.addresses = addresses;
        return this;
    }

    public Affiliate build() {
        Affiliate affiliate = new Affiliate();
        affiliate.setName(name);
        affiliate.setCode(code);
        affiliate.setBusinessName(businessName);
        affiliate.setDateOfIncorporation(dateOfIncorporation);
        affiliate.setLogo(logo);
        affiliate.setAddresses(addresses);
        affiliate.setPersons(persons);
       // affiliate.setSaleChannels(saleChannels);
        affiliate.setWebsite(website);
        return affiliate;
    }
}
