package com.tracebucket.common.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by ffl on 11-04-2014.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SaleChannelType {
    STORE("Store","STORE"),
    WEB("Web","WEB");

    private final String saleChannelType;
    private final String abbreviation;

    SaleChannelType(String saleChannelType, String abbreviation){
        this.saleChannelType = saleChannelType;
        this.abbreviation = abbreviation;
    }

    public String getSaleChannelType(){
        return saleChannelType;
    }

    public String getAbbreviation(){
        return abbreviation;
    }
}
