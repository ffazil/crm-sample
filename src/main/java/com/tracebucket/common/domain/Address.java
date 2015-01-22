package com.tracebucket.common.domain;

import com.tracebucket.common.dictionary.AddressType;
import com.tracebucket.infrastructure.ddd.annotation.ValueObject;
import com.tracebucket.infrastructure.ddd.domain.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@ValueObject
@Embeddable
public class Address {

    @Column(name = "NAME")
    @Basic(fetch = FetchType.EAGER)
    private String name;

    @Column(name = "BUILDING", length = 75)
    @Basic(fetch = FetchType.EAGER)
    private String building;

    @Column(name = "STREET", length = 100)
    @Basic(fetch = FetchType.EAGER)
    private String street;

    @Column(name = "REGION", length = 75)
    @Basic(fetch = FetchType.EAGER)
    private String region;

    @Column(name = "CITY", nullable = false, length = 75)
    @Basic(fetch = FetchType.EAGER)
    private String city;

    @Column(name = "DISTRICT", nullable = false, length = 75)
    @Basic(fetch = FetchType.EAGER)
    private String district;

    @Column(name = "STATE", nullable = false, length = 75)
    @Basic(fetch = FetchType.EAGER)
    private String state;

    @Column(name = "COUNTRY", nullable = false, length = 50)
    @Basic(fetch = FetchType.EAGER)
    private String country;

    @Column(name = "ZIP", nullable = false, length = 20)
    @Basic(fetch = FetchType.EAGER)
    private String zip;

    @Column(name = "ADDRESS_TYPE", nullable = false, columnDefinition = "ENUM('HEAD_OFFICE','BRANCH') default 'HEAD_OFFICE'")
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @Column(name = "CURRENT_ADDRESS", nullable = false, columnDefinition = "boolean default true")
    @Basic(fetch = FetchType.EAGER)
    private boolean currentAddress;

    public Address() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public boolean isCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(boolean currentAddress) {
        this.currentAddress = currentAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        if (!super.equals(o)) return false;

        Address address = (Address) o;

        if (building != null ? !building.equals(address.building) : address.building != null) return false;
        if (!city.equals(address.city)) return false;
        if (!country.equals(address.country)) return false;
        if (!district.equals(address.district)) return false;
        if (name != null ? !name.equals(address.name) : address.name != null) return false;
        if (region != null ? !region.equals(address.region) : address.region != null) return false;
        if (!state.equals(address.state)) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (!zip.equals(address.zip)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (building != null ? building.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + city.hashCode();
        result = 31 * result + district.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + zip.hashCode();
        return result;
    }
}
