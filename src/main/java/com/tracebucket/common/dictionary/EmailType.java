package com.tracebucket.common.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by Amarnath on 21-05-2014.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EmailType {
    PERSONAL("Personal","PERSONAL"),
    BUSINESS("Business","BUSINESS");

    private final String emailType;
    private final String abbreviation;

    EmailType(String emailType, String abbreviation){
        this.emailType = emailType;
        this.abbreviation = abbreviation;
    }

    public String getEmailType(){
        return emailType;
    }

    public String getAbbreviation(){
        return abbreviation;
    }
}
