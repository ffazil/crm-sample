package com.tracebucket.common.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by ffl on 18/04/14.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MeasurementUnitType {
    STANDARD("Standard","STANDARD"),
    OPTIONAL("Optional","OPTIONAL");

    private final String measurementUnitType;
    private final String abbreviation;

    MeasurementUnitType(String measurementUnitType, String abbreviation){
        this.measurementUnitType = measurementUnitType;
        this.abbreviation = abbreviation;
    }

    public String getMeasurementUnitType(){
        return measurementUnitType;
    }

    public String getAbbreviation(){
        return abbreviation;
    }
}
