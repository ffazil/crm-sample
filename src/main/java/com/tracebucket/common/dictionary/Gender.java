package com.tracebucket.common.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by ffl on 25-04-2014.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Gender {
    MALE("Male","MALE"),
    FEMALE("Female","FEMALE");

    private final String gender;
    private final String abbreviation;

    Gender(String gender, String abbreviation){
        this.gender = gender;
        this.abbreviation = abbreviation;
    }

    public String getGender(){
        return gender;
    }

    public String getAbbreviation(){
        return abbreviation;
    }
}
