package com.tracebucket.common.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by ffl on 11-04-2014.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AddressType {
    HEAD_OFFICE("Head Office","HEAD_OFFICE"),
    BRANCH("Branch", "BRANCH");

    private final String addressType;
    private final String abbreviation;

    AddressType(String addressType, String abbreviation){
        this.addressType = addressType;
        this.abbreviation = abbreviation;
    }

    public String getAddressType(){
        return addressType;
    }

    public String getAbbreviation(){
        return abbreviation;
    }
}
