package com.tracebucket.common.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by Amarnath on 21-05-2014.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PersonType {
    TECHNICAL("Technical","TECHNICAL"),
    ADMINISTRATIVE("Administrative","ADMINISTRATIVE");

    private final String personType;
    private final String abbreviation;

    PersonType(String personType, String abbreviation){
        this.personType = personType;
        this.abbreviation = abbreviation;
    }

    public String getPersonType(){
        return personType;
    }

    public String getAbbreviation(){
        return abbreviation;
    }
}
