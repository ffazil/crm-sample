package com.tracebucket.organization.rest.resource;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;

/**
 * Created by sadath on 10-Feb-15.
 */
public class CurrencyResource {
    private Long id;
    private boolean passive;
    private String name;
    private String iso4217Code;
    private String subUnit110;
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPassive() {
        return passive;
    }

    public void setPassive(boolean passive) {
        this.passive = passive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso4217Code() {
        return iso4217Code;
    }

    public void setIso4217Code(String iso4217Code) {
        this.iso4217Code = iso4217Code;
    }

    public String getSubUnit110() {
        return subUnit110;
    }

    public void setSubUnit110(String subUnit110) {
        this.subUnit110 = subUnit110;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}