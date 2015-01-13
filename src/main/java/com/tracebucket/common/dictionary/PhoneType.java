package com.tracebucket.common.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by Amarnath on 21-05-2014.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PhoneType {
    MOBILE("Mobile","MOBILE"),
    WORK("Work","WORK"),
    HOME("Home","HOME");

    private final String phoneType;
    private final String abbreviation;

    PhoneType(String phoneType, String abbreviation){
        this.phoneType = phoneType;
        this.abbreviation = abbreviation;
    }

    public String getPhoneType(){
        return phoneType;
    }

    public String getAbbreviation(){
        return abbreviation;
    }
}
