package com.tracebucket.common.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created with IntelliJ IDEA.
 * User: Gopinath
 * Date: 20/8/13
 * Time: 6:16 PM
 * To change this template use File | Settings | File Templates.
 */
@JsonFormat(shape = JsonFormat.Shape.SCALAR/*OBJECT*/)
public enum Status {
    ACTIVE("Active","ACTIVE"),
    INACTIVE("Inactive","INACTIVE");

    private final String status;
    private final String abbreviation;

    Status(String status, String abbreviation){
        this.status = status;
        this.abbreviation = abbreviation;
    }

    public String getStatus(){
        return status;
    }

    public String getAbbreviation(){
        return abbreviation;
    }
}
